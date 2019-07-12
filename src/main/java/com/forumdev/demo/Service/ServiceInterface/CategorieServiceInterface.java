package com.forumdev.demo.Service.ServiceInterface;

import com.forumdev.demo.Model.Categorie;

import java.util.List;

public interface CategorieServiceInterface
{
    List<Categorie> getAll();
    Categorie FindOne(Integer id);
    String  getCategoriesByName(String cat);

}
