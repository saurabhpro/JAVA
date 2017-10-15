package saurabh.udemy.springguru102springbootwithh2basic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import saurabh.udemy.springguru102springbootwithh2basic.repository.BookRepository;

@Controller
public class BookController {

	private BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {

		model.addAttribute("books", bookRepository.findAll());

		return "books";
	}
}