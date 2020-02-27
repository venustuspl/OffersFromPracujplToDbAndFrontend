/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package pl.venustus.Soup.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.venustus.Soup.domain.Offer;

import java.time.LocalDateTime;
import java.util.List;

public interface OfferRepository extends CrudRepository<Offer, Long> {

        @Override
        List<Offer> findAll();

        @Override
        long count();

        @Query(nativeQuery = true)
        List<Offer> checkIfOfferExists(@Param("URL") String url);

        @Query(nativeQuery = true)
        LocalDateTime getLastOfferDate();
}
