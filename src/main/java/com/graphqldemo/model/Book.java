package com.graphqldemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

/**
 * @author Gaurav Sharma
 */
@Table("books")
public class Book {

    @Id
    private String id;
    private String name;
    private int pages;

    public Book() {
    }

    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}