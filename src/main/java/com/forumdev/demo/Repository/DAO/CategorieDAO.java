package com.forumdev.demo.Repository.DAO;

import com.forumdev.demo.Model.Categorie;

import java.util.List;

public interface CategorieDAO
{
    List<Categorie> getAll();
    Categorie FindOne(Integer id);
    String getCategoriesByCat(String cat);

}
