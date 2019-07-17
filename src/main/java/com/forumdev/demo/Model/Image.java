package com.forumdev.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "Image")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Image
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_im;
    private String name;
    private String path;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_p")
    @JsonIgnore
    private Post post;

    public Image() {
    }

    public Image(String name, String path, Post post) {
        this.name = name;
        this.path = path;
        this.post = post;
    }

    public Integer getId_im() {
        return id_im;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
