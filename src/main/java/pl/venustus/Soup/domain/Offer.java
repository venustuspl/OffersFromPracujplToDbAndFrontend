/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

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
        query = "SELECT MAX(DATE_TIME) FROM OFFER"

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

    @Column(name = "DATE_TIME")
    private LocalDateTime dateTime;


}
