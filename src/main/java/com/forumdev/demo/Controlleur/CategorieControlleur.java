package com.forumdev.demo.Controlleur;

import com.forumdev.demo.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategorieControlleur
{
    @Autowired
    private CategorieService categorieService;
}
