package com.forumdev.demo.Repository.DAO;

import com.forumdev.demo.Model.Image;

public interface ImageDAO
{
    void uploadImage(Image image);
    void afficherImage(Image image);
}
