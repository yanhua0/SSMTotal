package org.total.entity;

import java.util.Date;

public class HotSale {
    private String name;
    private int price;
    private String img;
    private int id;
    private int number;
    private String wimg;
    private String bimg;
    private Date createTime;
    private String buycarimg;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBuycarimg() {
        return buycarimg;
    }

    public void setBuycarimg(String buycarimg) {
        this.buycarimg = buycarimg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getWimg() {
        return wimg;
    }

    public void setWimg(String wimg) {
        this.wimg = wimg;
    }

    public String getBimg() {
        return bimg;
    }

    public void setBimg(String bimg) {
        this.bimg = bimg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "HotSale{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                ", id=" + id +
                ", number=" + number +
                ", wimg='" + wimg + '\'' +
                ", bimg='" + bimg + '\'' +
                ", createTime=" + createTime +
                ", buycarimg='" + buycarimg + '\'' +
                '}';
    }

    public HotSale(String name, String img) {
        this.name = name;
        this.img = img;
    }
    public HotSale() {

    }
}
