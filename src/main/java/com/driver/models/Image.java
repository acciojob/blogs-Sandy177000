package com.driver.models;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    private String dimensions;
    private String description;

    public Image() {
        // Default constructor needed by JPA
    }

    public Image(String dimensions, String description) {
        this.dimensions = dimensions;
        this.description = description;
    }

    public int getId() {
        return imageId;
    }

    public void setId(int id) {
        this.imageId = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
