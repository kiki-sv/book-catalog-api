package com.example.bookcatalog.models;

import jakarta.persistence.*;

@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "SUMMARY")
    private String summary;

    @Column(name = "PUBLICATION_YEAR")
    private Integer publicationYear;

    @Column(name = "GENRE")
    private String genre;

    public Book() {

    }

    // Getter and Setter Methods
    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getSummary() {
        return this.summary;
    }

    public Integer getPublicationYear() {
        return this.publicationYear;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
