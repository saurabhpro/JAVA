package saurabh.udemy.springguru102springbootwithh2basic.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import saurabh.udemy.springguru102springbootwithh2basic.model.Author;
import saurabh.udemy.springguru102springbootwithh2basic.model.Book;
import saurabh.udemy.springguru102springbootwithh2basic.model.Publisher;
import saurabh.udemy.springguru102springbootwithh2basic.repository.AuthorRepository;
import saurabh.udemy.springguru102springbootwithh2basic.repository.BookRepository;
import saurabh.udemy.springguru102springbootwithh2basic.repository.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}

	private void initData() {

		Publisher publisher = new Publisher();
		publisher.setName("Harper Collins");
		publisherRepository.save(publisher);

		//Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", publisher);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);

		authorRepository.save(eric);
		bookRepository.save(ddd);


		Publisher publisher2 = new Publisher();
		publisher2.setName("Wrox");
		publisherRepository.save(publisher2);
		//Rod
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "23444", publisher2);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);

		authorRepository.save(rod);
		bookRepository.save(noEJB);
	}
}