package kz.urbanl.urbanlogistics.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User implements UserDetails {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String name;

    private String surname;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
                joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
                inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private List<UserRole> roles;

    private Status status;

    private String email;

    private String phoneNumber;

//    @OneToMany
//    @JoinColumn(name = "card_data_id")
//    private List<CardData> cardDataList;

    public Boolean userContainCompanyAdmin(){
        for(GrantedAuthority role : this.getAuthorities()){
            if(role.getAuthority().equals("COMPANY_ADMIN")){
                return true;
            }
        }
        return false;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
