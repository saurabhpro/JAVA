package saurabh.udemy.springguru102springbootwithh2basic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import saurabh.udemy.springguru102springbootwithh2basic.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}