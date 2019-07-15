package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.Dislike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DislikeRepository extends JpaRepository<Dislike,Integer>
{

    @Override
    Optional<Dislike> findById(Integer integer);

    @Override
    Dislike saveAndFlush(Dislike s);
}
