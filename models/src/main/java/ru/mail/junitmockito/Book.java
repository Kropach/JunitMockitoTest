package ru.mail.junitmockito;

public class Book {
    private Author author;
    private String name;

    public Book(Author author, String name) {
        this.author = author;
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
