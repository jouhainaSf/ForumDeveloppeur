package com.forumdev.demo.Model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Like
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_lik;
    @ColumnDefault(value = "0")
    private Integer likes;
    @OneToOne
    @JoinColumn(name = "post", referencedColumnName = "id_p")
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
