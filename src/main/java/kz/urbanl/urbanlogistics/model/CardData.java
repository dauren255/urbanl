package kz.urbanl.urbanlogistics.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "card_data")
@Data
public class CardData {

    @Id
    @Column(name = "card_data_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;

    private String exclusionDate;

    private String vcc;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
