package kz.urbanl.urbanlogistics.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "photo")
@Data
public class Photo {
    @Id
    @Column(name = "photo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photoId;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "photo_details_id", insertable = false, updatable = false)
    private PhotoDetails photoDetails;

}
