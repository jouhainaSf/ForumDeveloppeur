package com.forumdev.demo.Controlleur;

import com.forumdev.demo.Controlleur.ControlleurInterface.ImageControlleurInterface;
import com.forumdev.demo.Model.Image;
import com.forumdev.demo.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageControlleur implements ImageControlleurInterface
{
    @Autowired
    private ImageService imageService;

    @Override
    @PostMapping(path = "/addImage" , produces = "application/json" , consumes = "application/json")
    @ResponseBody
    public void addImage(@RequestBody Image image)
    {
        /*
        //related to the path method
        imageService.store(image);
        imageService.addImage(image1);
        */
         imageService.uploadImage(image);

    }



    @PostMapping(path = "/affImage" ,  consumes = "application/json")
    @ResponseBody
    public void affImage(@RequestBody Image image)
    {
        //je ne peux pas afficher une image par postman
        imageService.afficherImage(image);

    }


}
