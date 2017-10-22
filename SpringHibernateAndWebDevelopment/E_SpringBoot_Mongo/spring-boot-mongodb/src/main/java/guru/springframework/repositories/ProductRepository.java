package guru.springframework.repositories;

import guru.springframework.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jt on 1/10/17.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
}
