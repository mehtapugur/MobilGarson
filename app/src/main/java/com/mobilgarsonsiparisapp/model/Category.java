package com.mobilgarsonsiparisapp.model;

public class Category {
    public Category() {
    }


    public Category(String categoryName, String categoryImageUrl) {
        CategoryName = categoryName;
        CategoryImageUrl = categoryImageUrl;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getCategoryImageUrl() {
        return CategoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        CategoryImageUrl = categoryImageUrl;
    }

    private String CategoryName;
    private String CategoryImageUrl;
}
