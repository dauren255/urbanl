package kz.urbanl.urbanlogistics.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@Data
public class Location {
    @Id
    @Column(name = "location_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String longitude;

    private String latitude;
}
