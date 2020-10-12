package ru.mail.junitmockito;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Input library capacity");
            int capacity = scanner.nextInt();
            final Injector injector = Guice.createInjector();
            injector.getInstance(LibraryFactory.class).library(capacity);
        }catch (IllegalStateException | NoSuchElementException | IOException e) {
        }
    }
}
