package com.example.json_url_recyclerview_4;

public class MovieModelClass {

    String id;
    String name;
    String img;
    String wood;
    String length;
    String test;

    public MovieModelClass(String id, String name, String img, String wood, String length, String test) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.wood = wood;
        this.length = length;
        this.test = test;
    }

    public MovieModelClass() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getWood() {
        return wood;
    }

    public String getLength() {
        return length;
    }

    public String getTest() {
        return test;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
