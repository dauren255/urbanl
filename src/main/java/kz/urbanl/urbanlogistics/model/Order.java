package kz.urbanl.urbanlogistics.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mover_id")
    private Mover mover;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private Date startDate;

    private Date endDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "arrival_location_id", referencedColumnName = "location_id")
    private Location arrivalPlace;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_location_id", referencedColumnName = "location_id")
    private Location destinationPlace;

//    private Payment payment;

    private Status status;

    private Double rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_photo_details_id", referencedColumnName = "photo_details_id")
    private PhotoDetails photoDetails;

}
