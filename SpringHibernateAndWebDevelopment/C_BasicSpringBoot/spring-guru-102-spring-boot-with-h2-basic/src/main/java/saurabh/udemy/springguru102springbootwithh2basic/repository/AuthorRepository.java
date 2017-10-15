package saurabh.udemy.springguru102springbootwithh2basic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import saurabh.udemy.springguru102springbootwithh2basic.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}