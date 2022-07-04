package com.example.amogus.Domain;

import java.io.Serializable;

public class ElectronicDomain implements Serializable {
    private String title;
    private String pic;
    private String description;
    private Double fee;
    private int star;
    private int time;
    private int hot;
    private int numberInCart;

    public ElectronicDomain(String title, String pic, String description, Double fee, int star, int time, int hot) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
        this.star = star;
        this.time = time;
        this.hot = hot;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }
}
