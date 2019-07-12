package com.forumdev.demo.Service;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Repository.CategorieRepository;
import com.forumdev.demo.Repository.DAO.DAOImp.CategorieDAOImp;
import com.forumdev.demo.Service.ServiceInterface.CategorieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService implements CategorieServiceInterface
{

    @Autowired
    private CategorieDAOImp categorieDAOImp;

    @Override
    public List<Categorie> getAll() {
        return categorieDAOImp.getAll();
    }

    @Override
    public Categorie FindOne(Integer id) {
        return categorieDAOImp.FindOne(id);
    }

    @Override
    public String getCategoriesByName(String cat) {
        return categorieDAOImp.getCategoriesByCat(cat);
    }
}
