package com.group.libraryapp.controller.book;

import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import com.group.libraryapp.service.book.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest req)
    {
        bookService.saveBook(req);
    }

    @PostMapping("/book/loan")
    public void LoanBook(@RequestBody BookLoanRequest req)
    {
        bookService.loanBook(req);
    }

    @PutMapping("/book/return")
    public void ReturnBook(@RequestBody BookReturnRequest req)
    {
        bookService.returnBook(req);
    }
}
