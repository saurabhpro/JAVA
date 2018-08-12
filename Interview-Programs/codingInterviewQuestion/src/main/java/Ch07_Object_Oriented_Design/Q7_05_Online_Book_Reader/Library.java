package Ch07_Object_Oriented_Design.Q7_05_Online_Book_Reader;

import Ch07_Object_Oriented_Design.Q7_05_Online_Book_Reader.model.Book;

import java.util.HashMap;

public class Library {

    private HashMap<Integer, Book> books;

    public Book addBook(int id, String details) {
		/*
		if (books.containsKey(id)) {
			return null;
		}
		*/
        Book book = new Book(id, details);
        books.putIfAbsent(id, book);
        return book;
    }

    public boolean remove(Book b) {
        return remove(b.getID());
    }

    private boolean remove(int id) {
        return books.entrySet().removeIf(books -> books.getKey() == id);

		/*
		if (!books.containsKey(id)) {
			return false;
		}
		books.remove(id);
		return true;
		*/
    }

    public Book find(int id) {
        return books.get(id);
    }
}
