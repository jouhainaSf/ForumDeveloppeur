package com.forumdev.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Like
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id_lik;
    @ColumnDefault(value = "0")
    private Integer likes;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post", referencedColumnName = "id_p")
    @JsonIgnore
    private Post post;

    public Like() {
        likes=0;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Integer getId_l() {
        return id_lik;
    }
}
