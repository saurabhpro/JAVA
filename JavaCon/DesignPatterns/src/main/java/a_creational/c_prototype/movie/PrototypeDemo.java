package a_creational.c_prototype.movie;

public class PrototypeDemo {

	public static void main(String[] args) {
		Registry registry = new Registry();
		Movie movie = (Movie) registry.createItem("Movie");
		movie.setTitle("Creational Patterns in Java");

		System.out.println(movie);
		System.out.println(movie.getRuntime());
		System.out.println(movie.getTitle());
		System.out.println(movie.getUrl());

		Movie anotherMovie = (Movie) registry.createItem("Movie");
		anotherMovie.setTitle("Gang of Four");

		System.out.println(anotherMovie);
		System.out.println(anotherMovie.getRuntime());
		System.out.println(anotherMovie.getTitle());
		System.out.println(anotherMovie.getUrl());

		//see how it gives the previous books details
		Book book = (Book) registry.createItem("Book");
		book.setTitle("Gang");

		System.out.println(book);
		System.out.println(book.getNumberOfPages());
		System.out.println(book.getTitle());
		System.out.println(book.getUrl());

		//but since it was a shallow copy original book has been altered ? NO
		Book anotherBook = (Book) registry.createItem("Book");
		System.out.println(anotherBook);
		System.out.println(anotherBook.getNumberOfPages());
		System.out.println(anotherBook.getTitle());
		System.out.println(anotherBook.getUrl());


	}

}
