package Ch07_Object_Oriented_Design.Q7_05_Online_Book_Reader;

import Ch07_Object_Oriented_Design.Q7_05_Online_Book_Reader.model.Book;
import Ch07_Object_Oriented_Design.Q7_05_Online_Book_Reader.model.User;

public class Display {
    private Book activeBook;
    private User activeUser;
    private int pageNumber = 0;

    public void displayUser(User user) {
        activeUser = user;
        refreshUsername();
    }

    public void displayBook(Book book) {
        pageNumber = 0;
        activeBook = book;

        refreshTitle();
        refreshDetails();
        refreshPage();
    }

    private void refreshUsername() {
        /* updates username display */
    }

    private void refreshTitle() {
        /* updates title display */
    }

    private void refreshDetails() {
        /* updates details display */
    }

    private void refreshPage() {
        /* updated page display */
    }

    public void turnPageForward() {
        pageNumber++;
        refreshPage();
    }

    public void turnPageBackward() {
        pageNumber--;
        refreshPage();
    }
}
