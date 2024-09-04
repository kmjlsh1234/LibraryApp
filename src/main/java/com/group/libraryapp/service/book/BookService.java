package com.group.libraryapp.service.book;
import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.bookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loan_history.UserLoanHistory;
import com.group.libraryapp.domain.user.loan_history.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final bookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService(bookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest req)
    {
        bookRepository.save(new Book(req.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest req)
    {
        Book book = bookRepository.findByName(req.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        if(userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false))
            throw new IllegalArgumentException("Book already loaned");

        User user = userRepository.findByName(req.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        user.loanBook(book.getName());
    }

    @Transactional
    public void returnBook(BookReturnRequest req)
    {
        User user = userRepository.findByName(req.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        user.returnBook(req.getBookName());
    }
}
