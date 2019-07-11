package com.forumdev.demo.Controlleur;


import com.forumdev.demo.Model.Image;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Service.ImageService;
import com.forumdev.demo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PostControlleur
{
    @Autowired
    private PostService postService;

    @Autowired
    private ImageService imageService;


    @PostMapping(path = "/Poster" ,produces = "application/json" )
    @ResponseBody
    public Post Poster( @RequestParam("post") Post post , @RequestParam("img")  Image image)
    {

        Post p=new Post();
        p.setCategorie(post.getCategorie());
        p.setDescription(post.getDescription());
        p.setUser(post.getUser());
        p.setTitle(post.getTitle());
        image.setPost(p);
        imageService.uploadImage(image);
        p =postService.addPost(post);
        return p;
    }

}
