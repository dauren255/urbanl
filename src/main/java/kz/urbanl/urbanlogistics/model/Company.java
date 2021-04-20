package kz.urbanl.urbanlogistics.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@Data
public class Company {
    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String logo;

    @OneToMany
    @JoinColumn(name = "mover_id")
    private List<Mover> movers;

}
