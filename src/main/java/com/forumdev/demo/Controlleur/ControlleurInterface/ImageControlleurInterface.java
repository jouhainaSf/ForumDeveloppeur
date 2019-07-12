package com.forumdev.demo.Controlleur.ControlleurInterface;

import com.forumdev.demo.Model.Image;
import org.springframework.web.bind.annotation.RequestBody;

public interface ImageControlleurInterface
{
    void addImage(@RequestBody Image image);
}
