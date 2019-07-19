package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.Dislike;
import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>
{
    List<User> findAll();
    User save(User user);
    void deleteById(Integer integer);
    Optional<User> findById(Integer integer);
    User saveAndFlush(User user);

    @Query("select u from User u where u.email=:email and u.pwd=:pwd")
    User getUserByEmailAndPwd(@Param("email") String email, @Param("pwd") String pwd);

    @Query("select u from User u where u.email=:email ")
    User getUserByEmail(@Param("email") String email);

    @Query("select u from User u where u.pwd=:pwd ")
    User getUserByPwd(@Param("pwd") String pwd);

    @Query("select u.likes from User u where u.id_u=:id_u ")
    List<Like> getLikes(@Param("id_u") Integer id_u);
    @Query("select u.dislikes from User u where u.id_u=:id_u ")
    List<Dislike> getDislikes(@Param("id_u") Integer id_u);

    @Query("select u.posts from User u where u.id_u=:id_u ")
    List<Post> getPosts(@Param("id_u") Integer integer);



}
