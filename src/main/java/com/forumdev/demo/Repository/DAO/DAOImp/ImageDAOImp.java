package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.Image;
import com.forumdev.demo.Repository.DAO.ImageDAO;
import com.forumdev.demo.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.Base64;

@Repository
public class ImageDAOImp implements ImageDAO
{
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public  void uploadImage(Image image)
    {
        String base64Image = "";
        File file = new File(image.getPath());
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a Image file from file system
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
            base64Image = Base64.getEncoder().encodeToString(imageData);
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
        image.setDescription(base64Image);
        imageRepository.save(image) ;
    }

    @Override
    public void afficherImage(Image image)
    {
        Image image1=imageRepository.getOne(image.getId_im());
        try (FileOutputStream imageOutFile = new FileOutputStream(image1.getPath())) {
            // Converting a Base64 String into Image byte array
            byte[] imageByteArray = Base64.getDecoder().decode(image1.getDescription());
            imageOutFile.write(imageByteArray);
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }

    }
}
