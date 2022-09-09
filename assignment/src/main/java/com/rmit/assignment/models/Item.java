package com.rmit.assignment.models;

import java.util.List;

import javax.persistence.*;

import com.rmit.assignment.dao.ItemDao;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "desc")
    private String desc;

    @Column(name = "imagePath")
    private String imagePath;

    @Column(name = "price")
    private String price;

    public Item() {
    }

    public Item(ItemDao itemDao) {
        this.id = itemDao.getId();
        this.title = itemDao.getTitle();
        this.desc = itemDao.getDesc();
        this.imagePath = itemDao.getImagePath();
        this.price = itemDao.getPrice();
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
