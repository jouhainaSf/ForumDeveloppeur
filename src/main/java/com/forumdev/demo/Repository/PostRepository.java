package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer>
{
    @Query("select p from Post p where p.categorie=:categorie")
    Post findByCategorie(@Param("categorie") Integer categorie );

}
