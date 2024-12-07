package com.klef.jfsd.exam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.repository.BookRepository;

@Service
public class BookService 
{
	@Autowired
    private BookRepository bookRepository;

    public Book updateBook(int bookId, Book updatedBook) {
        Optional<Book> existingBookOpt = bookRepository.findById(bookId);

        if (existingBookOpt.isPresent()) {
            Book existingBook = existingBookOpt.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setPublishedYear(updatedBook.getPublishedYear());
            return bookRepository.save(existingBook);
        } else {
            throw new RuntimeException("Book with ID " + bookId + " not found.");
        }
    }

}
