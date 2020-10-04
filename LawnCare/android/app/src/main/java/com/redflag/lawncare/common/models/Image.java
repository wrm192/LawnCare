package com.redflag.lawncare.common.models;

public class Image {

    private String src;
    private int width;
    private int height;

    public Image() {}

    public Image(String src, int width, int height) {
        this.src = src;
        this.width = width;
        this.height = height;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Image{" +
                "src='" + src + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
