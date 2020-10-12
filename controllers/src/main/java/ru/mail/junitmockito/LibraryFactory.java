package ru.mail.junitmockito;

import java.io.IOException;

public class LibraryFactory {
    public void library(int capacity) throws IOException, ArrayIndexOutOfBoundsException {
        Library library = new Library(new FileBookFactory("Books.txt"),capacity);
        library.printInConsole();
    }
}
