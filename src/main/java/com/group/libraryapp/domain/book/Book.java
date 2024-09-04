package com.group.libraryapp.domain.book;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false)
    private String name;

    public Book(String name) {
        this.name = name;
    }

    protected Book() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
