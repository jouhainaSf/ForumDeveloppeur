package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends JpaRepository<Image,Integer>
{

}
