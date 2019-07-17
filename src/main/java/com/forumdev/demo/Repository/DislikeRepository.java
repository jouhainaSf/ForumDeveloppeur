package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.Dislike;
import com.forumdev.demo.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DislikeRepository extends JpaRepository<Dislike,Integer>
{

    @Override
    Optional<Dislike> findById(Integer integer);

    @Override
    Dislike saveAndFlush(Dislike s);

    @Query("select l from Dislike l where l.post=:id_p")
    Dislike fingByPost(@Param("id_p")Post post);
}
