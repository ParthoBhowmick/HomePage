package com.example.homepagedemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("file_name")
    @Expose
    private String fileName;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("product_slug")
    @Expose
    private String productSlug;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("wp_data")
    @Expose
    private Object wpData;
    @SerializedName("badge")
    @Expose
    private Object badge;
    @SerializedName("sell_price")
    @Expose
    private String sellPrice;

    public Boolean isLoading() {
        return isLoading;
    }

    public void setLoading(Boolean loading) {
        isLoading = loading;
    }

    @SerializedName("regular_price")
    @Expose
    private String regularPrice;
    @SerializedName("variants")
    @Expose
    private Integer variants;

    private Boolean isLoading = false;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProductSlug() {
        return productSlug;
    }

    public void setProductSlug(String productSlug) {
        this.productSlug = productSlug;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Object getWpData() {
        return wpData;
    }

    public void setWpData(Object wpData) {
        this.wpData = wpData;
    }

    public Object getBadge() {
        return badge;
    }

    public void setBadge(Object badge) {
        this.badge = badge;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }

    public Integer getVariants() {
        return variants;
    }

    public void setVariants(Integer variants) {
        this.variants = variants;
    }

}