package com.graphqldemo.service;

import com.graphqldemo.model.Book;
import com.graphqldemo.repo.BookRepo;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public DataFetcher<CompletableFuture<Book>> getBook() {

        return environment -> {
            String bookId = environment.getArgument("id");
            return bookRepo.getBook(bookId).toFuture();
        };
    }

    public DataFetcher<CompletableFuture<List<Book>>> getBooks() {
        return environment -> bookRepo.getBooks().collectList().toFuture();
    }

    public DataFetcher<CompletableFuture<String>> createBook() {
        return environment -> {
            String name = environment.getArgument("name");
            int pages = environment.getArgument("pages");
            return bookRepo.createBook(new Book(name, pages)).toFuture();
        };
    }
}
