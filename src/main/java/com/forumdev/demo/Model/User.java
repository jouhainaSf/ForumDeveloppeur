package com.forumdev.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_u;
    private String FirstName ;
    private String LastName ;
    private String email ;
    private String pwd ;
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Comment> comments;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    public User() {
    }

    public User(String firstName, String lastName, String email, String pwd, List<Comment> comments, List<Post> posts) {
        FirstName = firstName;
        LastName = lastName;
        this.email = email;
        this.pwd = pwd;
        this.comments = comments;
        this.posts = posts;
    }

    public Integer getId_u() {
        return id_u;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
