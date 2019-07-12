package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Integer>
{

    @Override
    Optional<Post> findById(Integer integer);

    @Override
    Post saveAndFlush(Post s);

    @Override
    void delete(Post post);
}
