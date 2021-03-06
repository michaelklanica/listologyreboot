package com.codeup.listology.models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
//    PROPERTIES:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @OneToOne
    private User author;

//    CONSTRUCTORS:
    public Post() {}

    public Post(String title, String body, User author) {
        this.author = author;
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body, User author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }

//    GETTERS and SETTERS:
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getAuthor() {
        return this.author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

}
