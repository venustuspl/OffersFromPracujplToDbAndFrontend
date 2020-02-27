package pl.venustus.Soup.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@NamedNativeQuery(
        name = "Offer.checkIfOfferExists",
        query = "SELECT * FROM OFFER WHERE URL = :URL ",
        resultClass = Offer.class
)

@NamedNativeQuery(
        name = "Offer.getLastOfferDate",
        query = "SELECT MAX(DATETIME) FROM OFFER",
        resultClass = Offer.class
)


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "OFFER")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "URL", unique = true)
    private String url;

    @Column(name = "DATETIME")
    private LocalDateTime dateTime;


}
