package com.forumdev.demo.Repository.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategorieDAO
{
    @Query("select c.cat from Categorie c where c.cat=:name")
    String getCategoriesByCat(@Param("name") String cat);


}
