package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategorieRepository extends JpaRepository<Categorie,Integer>
{
    @Query("select c.cat from Categorie c where c.cat=:name")
    String getCategoriesByCat(@Param("name") String cat);
}
