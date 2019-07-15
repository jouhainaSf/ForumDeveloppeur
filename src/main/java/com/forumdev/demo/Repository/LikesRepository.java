package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Like,Integer>
{
    @Override
    Optional<Like> findById(Integer integer);

    @Override
    Like save(Like s);
}
