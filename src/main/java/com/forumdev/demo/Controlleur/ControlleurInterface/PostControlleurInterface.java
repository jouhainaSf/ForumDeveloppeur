package com.forumdev.demo.Controlleur.ControlleurInterface;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Model.Post;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PostControlleurInterface
{
    Post Poster(Post post );
    List<Post> getPostByCategorie(@RequestBody Categorie categorie);
    Post modifyPost(@RequestBody Post post);
    void deletePost(@RequestBody Post post);
    Post afficherPost(@RequestBody Post post);
}
