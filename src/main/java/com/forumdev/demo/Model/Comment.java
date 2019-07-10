package com.forumdev.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Comment")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"date"},allowGetters = true)
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_com ;
    private String contenue;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_p")
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_u")
    private User user;
    @CreatedDate
    @Column(name = "date",nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    public Comment() {
    }

    public Comment(String contenue, Post post, User user) {
        this.contenue = contenue;
        this.post = post;
        this.user = user;
    }

    public Integer getId_com() {
        return id_com;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

}

