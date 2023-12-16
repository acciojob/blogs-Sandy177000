package com.driver.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // Correcting the type to User

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String title;
    private String content;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blog")
    private List<Image> images;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    private Date pubDate;

    public Blog() {
        // Default constructor needed by JPA
    }

    public Blog(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    // getters and setters
}
