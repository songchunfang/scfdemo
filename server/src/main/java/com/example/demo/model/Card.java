package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="card")
public class Card {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;

    @NotBlank
    private String content;

    @Column(name = "joke_id", nullable = false)
    private Integer jokeId;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Integer getJokeId() {
        return jokeId;
    }

    public void setJokeId(Integer jokeid) {
        this.jokeId = jokeid;
    }
}