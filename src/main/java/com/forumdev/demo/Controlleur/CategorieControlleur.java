package com.forumdev.demo.Controlleur;

import com.forumdev.demo.Controlleur.ControlleurInterface.CategorieControlleurInterface;
import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
@CrossOrigin("*")
public class CategorieControlleur implements CategorieControlleurInterface
{
    @Autowired
    private CategorieService categorieService;

    @Override
    @GetMapping(path = "/categories" ,produces = "application/json")
    public List<Categorie> getAll()
    {
        return categorieService.getAll();
    }

    @PostMapping(path = "/getCategorie" , consumes = "application/json" , produces = "application/json")
    @ResponseBody
    public Categorie getCategrie(@RequestBody Categorie categorie)
    {
         return categorieService.FindOne(categorie.getId_cat());
    }
}
