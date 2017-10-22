package udemy.saurabh.springguru201restfulfruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udemy.saurabh.springguru201restfulfruits.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
	Category findByName(String s);
}