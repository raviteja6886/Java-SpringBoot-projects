package com.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookstore.entities.Book;
import com.bookstore.services.BookService;

@Controller
public class BookController {
	BookService bookService;
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	@GetMapping("/home")
	public String home() {
		return "home-page";
	}
	@GetMapping("/booksList")
	public String showBooks(Model m) {
		m.addAttribute("books", bookService.showBookList());
		return "booksList";
	}
	@GetMapping("/booksList/new")
	public String addBook(Model m) {
		Book book = new Book();
		m.addAttribute("book", book);
		return "addbook";
	}
	@PostMapping("/booksList")
	public String saveBook(@ModelAttribute("book")Book book) {
		bookService.saveBook(book);
		return "redirect:/booksList";
	}
	@GetMapping("/booksList/edit/{id}")
	public String getBookById(@PathVariable Long id,Model m) {
		m.addAttribute("book", bookService.getBookById(id));
		
		return "editBook";
	}
	@PostMapping("/booksList/{id}")
	public String updateBook(@PathVariable Long id,@ModelAttribute("book")Book book) {
		Book oldBook=bookService.getBookById(id);
		oldBook.setId(id);
		oldBook.setBookName(book.getBookName());
		oldBook.setAuthorName(book.getAuthorName());
		oldBook.setPrice(book.getPrice());
		bookService.saveBook(oldBook);
		return "redirect:/booksList";
		
	}
	@GetMapping("/booksList/{id}")
	public String deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return "redirect:/booksList";
	}
	

}
