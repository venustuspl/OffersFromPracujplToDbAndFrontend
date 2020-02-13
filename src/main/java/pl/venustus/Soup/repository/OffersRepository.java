package pl.venustus.Soup.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.venustus.Soup.domain.Offers;

import java.util.List;

public interface OffersRepository extends CrudRepository<Offers, Long> {

        @Query(nativeQuery = true)
        List<Offers> checkIfOfferExists(@Param("URL") String url);
}
