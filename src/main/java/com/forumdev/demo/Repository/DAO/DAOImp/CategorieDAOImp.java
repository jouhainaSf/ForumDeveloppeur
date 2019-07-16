package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Repository.CategorieRepository;
import com.forumdev.demo.Repository.DAO.CategorieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategorieDAOImp implements CategorieDAO {

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public List<Categorie> getAll()
    {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie FindOne(Integer id)
    {
        return categorieRepository.findById(id).get();
    }

    @Override
    public String getCategoriesByCat(String cat)
    {
        return categorieRepository.getCategoriesByCat(cat);
    }
}
