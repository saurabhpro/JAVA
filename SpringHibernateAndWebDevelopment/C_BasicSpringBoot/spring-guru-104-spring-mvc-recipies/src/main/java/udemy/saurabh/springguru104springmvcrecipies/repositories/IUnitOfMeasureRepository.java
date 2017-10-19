package udemy.saurabh.springguru104springmvcrecipies.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.saurabh.springguru104springmvcrecipies.model.UnitOfMeasure;

public interface IUnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
