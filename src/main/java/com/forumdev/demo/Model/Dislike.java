package com.forumdev.demo.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dislike")
public class Dislike
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_dis;
    @ColumnDefault(value = "0")
    private Integer dislikes;
    @OneToOne
    @JoinColumn(name = "post", referencedColumnName = "id_p")
    @JsonIgnore
    private Post post;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Users_Dislikes",
            joinColumns = { @JoinColumn(name = "id_dis") },
            inverseJoinColumns = { @JoinColumn(name = "id_u") }
    )
    @JsonIgnore
    private List<User> users;

    public Dislike() {
        dislikes=0;
    }

    public Dislike(Integer dislikes, Post post) {
        this.dislikes = dislikes;
        this.post = post;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Integer getId_dis() {
        return id_dis;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
