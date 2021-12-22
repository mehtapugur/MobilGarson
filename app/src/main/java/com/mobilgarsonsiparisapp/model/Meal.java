package com.mobilgarsonsiparisapp.model;

public class Meal {


    public Meal() {
    }


    public Meal(String name, String category, String imgURL, String detailImgURL, String price) {
        Name = name;
        Category = category;
        ImgURL = imgURL;
        DetailImgURL = detailImgURL;
        Price = price;
    }

    private String Name;
    private String Category;
    private String ImgURL;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getImgURL() {
        return ImgURL;
    }

    public void setImgURL(String imgURL) {
        ImgURL = imgURL;
    }

    public String getDetailImgURL() {
        return DetailImgURL;
    }

    public void setDetailImgURL(String detailImgURL) {
        DetailImgURL = detailImgURL;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    private String DetailImgURL;
    private String Price;
}
