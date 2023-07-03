package org.example.repository3;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Book3 extends Item3 {
    private String author;

    private String isbn;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
