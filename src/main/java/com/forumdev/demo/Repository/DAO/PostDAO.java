package com.forumdev.demo.Repository.DAO;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostDAO
{
    @Query("select p from Post p where p.categorie=:categorie")
    List<Post> findByCategorie(@Param("categorie") Categorie categorie );
}
