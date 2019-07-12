package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image,Integer>
{
    @Override
    Image save(Image s);

    @Override
    Optional<Image> findById(Integer integer);
}
