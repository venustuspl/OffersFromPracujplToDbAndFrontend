package pl.venustus.Soup.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.venustus.Soup.domain.Offer;

import java.util.List;

public interface OfferRepository extends CrudRepository<Offer, Long> {

        @Override
        List<Offer> findAll();

        @Query(nativeQuery = true)
        List<Offer> checkIfOfferExists(@Param("URL") String url);
}
