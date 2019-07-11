package com.forumdev.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Categorie")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Categorie
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_cat;
    private String cat;
    @OneToMany(
            mappedBy = "categorie",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Post> posts;

    public Categorie() {
    }

    public Categorie(String cat, List<Post> posts) {
        this.cat = cat;
        this.posts = posts;
    }

    public Integer getId_cat() {
        return id_cat;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
