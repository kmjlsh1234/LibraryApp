package com.group.libraryapp.domain.user.loan_history;

import com.group.libraryapp.domain.user.User;
import jakarta.persistence.*;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @ManyToOne
    private User user;

    private String bookName;

    private boolean isReturn;



    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public void DoReturn() {
        this.isReturn = true;
    }

    public String getBookName() {
        return bookName;
    }
}
