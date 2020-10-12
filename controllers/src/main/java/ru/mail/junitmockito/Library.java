package ru.mail.junitmockito;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Library {
    private @NotNull FileBookFactory bookFactory;
    private int capacity;
    private Book[] books;

    public Library(@NotNull FileBookFactory bookFactory, int capacity) throws IOException, ArrayIndexOutOfBoundsException {
        this.bookFactory = bookFactory;
        this.capacity = capacity;
        books = new Book[capacity];
        if (bookFactory.books().toArray().length > capacity)
            throw new ArrayIndexOutOfBoundsException("capacity smaller than number of books");
        else {
            books = bookFactory.books().toArray(books);
        }
    }

    public void addBook(Book book) throws ArrayIndexOutOfBoundsException {
        if (books.length < capacity) {
            books[books.length].setAuthor(book.getAuthor());
            books[books.length].setName(book.getName());
        }else throw new ArrayIndexOutOfBoundsException ("there are no free cells");
    }

    public Book getBook(int cellNumber) throws ArrayIndexOutOfBoundsException {
        if (cellNumber < books.length){
            try {
                System.out.println("book:" + books[cellNumber].getName());
                System.out.println("cell number: " + (cellNumber+1));
                return books[cellNumber];
            } catch (NullPointerException e){
                System.out.println("There is no cell with this number");
            }
        }
        return new Book(new Author("Empty"), "Empty");
    }

    public void printInConsole() {
        for (int i = 0; i < books.length; i++) {
            try {
                System.out.println("book: " + books[i].getName() +
                        " author: " + books[i].getAuthor().getName() + " cell number: " + (i+1));
            }catch (NullPointerException e){
                System.out.println("empty cell");
            }
        }
    }
}
