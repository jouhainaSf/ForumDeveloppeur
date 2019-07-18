package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikesRepository extends JpaRepository<Like,Integer>
{
    @Override
    Optional<Like> findById(Integer integer);

    @Override
    Like save(Like s);

    @Query("select l from Like l where l.post=:id_p")
    Like fingByPost(@Param("id_p")Post post);
}
