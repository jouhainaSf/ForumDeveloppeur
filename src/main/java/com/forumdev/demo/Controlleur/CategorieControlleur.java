package com.forumdev.demo.Controlleur;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategorieControlleur
{
    @Autowired
    private CategorieService categorieService;

    @PostMapping(path = "categories" ,produces = "application/json")
    public List<Categorie> getAll()
    {
        return categorieService.getAll();
    }
}
