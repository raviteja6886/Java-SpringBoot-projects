package com.bookstore.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.entities.Book;
import com.bookstore.repositories.BookRepository;
import com.bookstore.services.BookService;
@Service
public class BookServiceImpl implements BookService {
	BookRepository bookRepo;
	public BookServiceImpl(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}
	@Override
	public List<Book> showBookList() {
		
		return bookRepo.findAll();
	}
	@Override
	public Book saveBook(Book book) {
		
		return bookRepo.save(book);
	}
	@Override
	public Book getBookById(Long id) {
		
		return bookRepo.findById(id).get();
	}
	@Override
	public Book updateBook(Book book) {
		
		return bookRepo.save(book);
	}
	@Override
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
		
	}

}
