package kz.urbanl.urbanlogistics.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "photo")
@Data
public class Photo {
    @Id
    @Column(name = "photo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photoId;

    private String photo;

    @OneToMany
    @JoinColumn(name = "photo_details_id")
    private List<PhotoDetails> photoDetails;

//    @ManyToOne
//    @JoinColumn(name = "order_id", insertable = false, updatable = false)
//    private Order order;
}
