package com.forumdev.demo.Model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Post")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_p;
    private String description ;
    private String title ;
    @OneToOne(mappedBy = "post" )
    private Like likes;
    @OneToOne(mappedBy = "post" )
    private Dislike dislikes;
    @ColumnDefault("0")
    private Integer rate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cat")
    @JsonView
    private Categorie categorie;
    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Image> images;
    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL
    )

    private List<Comment> comments;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "id_u")
    private User user;

    @CreationTimestamp
    private Date dateCreation;

    public Post() {

    }

    public Post(String description, Like likes, Dislike dislikes, Integer rate, Categorie categorie, List<Image> images, List<Comment> comments, User user) {
        this.description = description;
        this.likes = likes;
        this.dislikes = dislikes;
        this.rate = rate;
        this.categorie = categorie;
        this.images = images;
        this.comments = comments;
        this.user = user;
    }

    public Integer getId_p() {
        return id_p;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Like getLikes() {
        return likes;
    }

    public void setLikes(Like likes) {
        this.likes = likes;
    }

    public Dislike getDislikes() {
        return dislikes;
    }

    public void setDislikes(Dislike dislikes) {
        this.dislikes = dislikes;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
