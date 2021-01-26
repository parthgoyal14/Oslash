package com.example.oslash.demo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.convert.JodaTimeConverters;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Tweets")
public class Tweet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Text")
    private String text;

    @Column(name = "Timestamp")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(referencedColumnName = "Id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Tweet(){
        super();
    }

    public Tweet(Long id, String text, LocalDateTime dateTime, User user){
        super();
        this.id = id;
        this.text = text;
        this.dateTime = dateTime;
        this.user = user;
    }

    public Long getId() {
        return id;
    }
    public String getText() {
        return text;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public User getUser() {
        return user;
    }

    @PrePersist
    public void timestamp(){
        this.dateTime = LocalDateTime.now();
    }
}
