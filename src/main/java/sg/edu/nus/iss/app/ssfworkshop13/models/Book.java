package sg.edu.nus.iss.app.ssfworkshop13.models;

import java.util.LinkedList;
import java.util.List;

public class Book {
    private List<Person> book = new LinkedList<>();

    public List<Person> getBook() {
        return book;
    }

    public void setBook(List<Person> book) {
        this.book = book;
    }

}
