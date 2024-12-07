package com.klef.jfsd.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController 
{
	 @Autowired
	    private BookService bookService;

	    @PutMapping("/{id}")
	    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
	        try {
	            Book updated = bookService.updateBook(id, updatedBook);
	            return ResponseEntity.ok(updated);
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

}
