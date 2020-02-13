package pl.venustus.Soup.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@NamedNativeQuery(
        name = "Offers.checkIfOfferExists",
        query = "SELECT * FROM OFFER WHERE URL = :URL ",
        resultClass = Offers.class
)

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "OFFER")
public class Offers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "URL", unique = true)
    private String url;

    private LocalDateTime dateTime = LocalDateTime.now();


}
