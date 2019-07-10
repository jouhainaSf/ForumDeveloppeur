package com.forumdev.demo.Controlleur;

import com.forumdev.demo.Model.Image;
import com.forumdev.demo.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageControlleur
{
    @Autowired
    private ImageService imageService;

    @PostMapping(path = "/addImage" , produces = "application/json")
    @ResponseBody
    public Resource addImage(@RequestParam("img")MultipartFile image)
    {

        Image image1=new Image();
        image1.setName(image.getName());
        image1.setPath(image.getOriginalFilename());
        imageService.store(image);
        imageService.addImage(image1);
        return imageService.loadFile(image1.getPath());


    }




}
