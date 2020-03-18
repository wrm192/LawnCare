package com.redflag.lawncare.common.models;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    private Long id;
    @SerializedName("title")
    private String title;
    @SerializedName("body_html")
    private String description;
    @SerializedName("image")
    private Image image;

    public Product(Long id, String title, String bodyHtml, Image image) {
        this.id = id;
        this.title = title;
        this.description = bodyHtml;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String bodyHtml) {
        this.description = bodyHtml;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", bodyHtml='" + description + '\'' +
                ", image=" + image +
                '}';
    }
}
