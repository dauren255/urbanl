package kz.urbanl.urbanlogistics.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "movers")
@Data
public class Mover {
    @Id
    @Column(name = "mover_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carName;

    private String carNumber;

    private String carData;

    private Status status;

    private Double rating;

    private Status driverLicense;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private Company company;
}
