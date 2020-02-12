package pl.venustus.Soup.repository;

import org.springframework.data.repository.CrudRepository;
import pl.venustus.Soup.domain.Offers;

public interface OffersRepository extends CrudRepository<Offers, Long> {
}
