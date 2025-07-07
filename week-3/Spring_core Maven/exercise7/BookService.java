package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private LoggerService loggerService;

    // Constructor injection for LoggerService
    public BookService(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    // Setter injection for BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookName) {
        loggerService.log("Adding book: " + bookName);
        bookRepository.saveBook(bookName);
    }
}
