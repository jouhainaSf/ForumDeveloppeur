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
import java.util.Base64;
import java.io.File;
import java.io.IOException;
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


public Image addImage(Image image)
{
    return imageRepository.save(image);
}


}
