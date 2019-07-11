package com.forumdev.demo.Service;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Repository.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService
{
    private CategorieRepository  categorieRepository;

    public List<Categorie> getAll()
    {
        return categorieRepository.findAll();
    }

    public Categorie FindOne(Integer id)
    {
        return categorieRepository.findById(id).get();
    }
    public String  getCategoriesByName(String cat)
    {
        return categorieRepository.getCategoriesByCat(cat);

    }

}
