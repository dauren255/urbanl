package kz.urbanl.urbanlogistics.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "movers")
@Data
public class Mover extends User{
    @Id
    @Column(name = "mover_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carName;

    private String carNumber;

    private String carData;

    private Double rating;

    private String driverLicense;
    
    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private Company company;
}
