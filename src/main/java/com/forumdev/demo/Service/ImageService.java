package com.forumdev.demo.Service;

import com.forumdev.demo.Model.Image;
import com.forumdev.demo.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.util.Base64;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.Assert.*;

@Service
public class ImageService
{
    @Autowired
    private ImageRepository imageRepository;
    private final Path rootLocation = Paths.get("src/test/resources");


/*
//cette methode ajoute une image au path indiquer dans le projet
    private final Path rootLocation = Paths.get("src/test/resources");


    public void store(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        } catch (Exception e) {

            System.out.println("FAIL "+e.getMessage());;
            //  throw new RuntimeException("FAIL!");
        }
    }

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }




    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {

            System.out.println(e.getMessage());
            throw new RuntimeException("Could not initialize image!");
        }
    }
*/

//la methide base64

    public  Image uploadImage(Image image) {
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
    return imageRepository.save(image) ;
}

public void afficherImage(Image image)
{
    try (FileOutputStream imageOutFile = new FileOutputStream(image.getPath())) {
        // Converting a Base64 String into Image byte array
        byte[] imageByteArray = Base64.getDecoder().decode(image.getDescription());
        imageOutFile.write(imageByteArray);
    } catch (FileNotFoundException e) {
        System.out.println("Image not found" + e);
    } catch (IOException ioe) {
        System.out.println("Exception while reading the Image " + ioe);
    }

}


}
