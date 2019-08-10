package me.aboullaite.bookstore.service;

import me.aboullaite.bookstore.model.Author;
import me.aboullaite.bookstore.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

@Service
public class BookService {

    private List<Book> books;

    public BookService() {
        this.books = new ArrayList<>();
        books.add(new Book("Automatas",88.00, Arrays.asList(new Author("Jose Autom"))));
        books.add(new Book("Fisica", 80.9,  Arrays.asList(new Author("Richard Patterson"), new Author("Candice Fox"))));
        books.add(new Book("Metodos",45.00, Arrays.asList(new Author("Edward Toez "), new Author("James Patterson"))));
        books.add(new Book("Ciencia - ",40.00, Arrays.asList(new Author("Frederich "))));
    }

    public List<Book> getBooks(){
        return this.books;
    }

    public Stream<Book> getBookByPrecio(Double precio){
        return books
                .stream()
                .filter(b -> {
                     return b.getPrecio().equals(precio);
                    }
                );
    }

    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> longExecutionMethod() {
        try {
            // Simulate random poor performing method!
            if(ThreadLocalRandom.current().nextInt() > 0.5)
                Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.books;

    }

    

}
