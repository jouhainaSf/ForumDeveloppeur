package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.Categorie;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CategorieRepository extends JpaRepository<Categorie,Integer>
{
    @Override
    List<Categorie> findAll();

    @Override
    Optional<Categorie> findById(Integer integer);
}
