package kz.urbanl.urbanlogistics.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "photo_details")
@Data
public class PhotoDetails {
    @Id
    @Column(name = "photo_details_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "photo_id", insertable = false, updatable = false)
//    private Photo photo;

    private Integer weight;
    private Integer length;
    private Integer width;

}
