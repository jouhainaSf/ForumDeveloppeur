package com.forumdev.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

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
    @JsonIgnore
    private Post post;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Users_Likes",
            joinColumns = { @JoinColumn(name = "id_lik") },
            inverseJoinColumns = { @JoinColumn(name = "id_u") }
    )
    private List<User> users;

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public void setId_lik(Integer id_lik) {
        this.id_lik = id_lik;
    }
}
