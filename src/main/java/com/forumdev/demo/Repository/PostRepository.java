package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Integer>
{

    @Override
    List<Post> findAll();

    @Override
    Optional<Post> findById(Integer integer);

    @Override
    Post saveAndFlush(Post s);

    @Override
    void deleteById(Integer integer);

    @Query("select p from Post p where p.categorie=:categorie")
    List<Post> findByCategorie(@Param("categorie") Categorie categorie );

    @Query("select p from Post p where p.user=:user")
    List<Post> findByUser(@Param("user") User user );

    @Query("select p.title from Post p where p.id_p=:id_p")
    String getTitle(@Param("id_p") Integer integer );
    @Query("select p.categorie from Post p where p.id_p=:id_p")
    Categorie getCategorie(@Param("id_p") Integer integer );
    @Query("select p.user from Post p where p.user=:user ")
    User getUser(@Param("user") User user  );
    @Query("select p.rate from Post p where p.id_p=:id_p")
    Integer getRate(@Param("id_p") Integer integer );

}
