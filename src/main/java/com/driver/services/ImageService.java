package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog b = blogRepository2.findById(blogId).get();
        List<Image> list = b.getImages();
        Image img = new Image(dimensions,description);
        list.add(img);
        return img;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        String[] st = screenDimensions.split("X");
        int x = Integer.parseInt(st[0]);
        int y = Integer.parseInt(st[1]);

        Image img = imageRepository2.findById(id).get();

        String[] s = img.getDimensions().split("X");
        int xx = Integer.parseInt(s[0]);
        int yy = Integer.parseInt(s[1]);

        return (x*y)/(xx*yy);

    }
}








