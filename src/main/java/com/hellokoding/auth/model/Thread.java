package com.hellokoding.auth.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "thread")
public class Thread {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "thread_id")
    private Long id;
    private String title;
    private String content;
    @Column(name = "date", nullable = true)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;


    @PrePersist
    protected void onCreate() {
        date = new Date();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Thread() {
    }


    public Thread(String title, String content, Date date, User user) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
