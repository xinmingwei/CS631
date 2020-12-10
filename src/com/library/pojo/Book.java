package com.library.pojo;

/**
 * @author MSI-NB
 */
public class Book extends Document{
    private String isbn;

    public Book(){
        super();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                '}';
    }
}
