package com.ssl.springboot2thymeleaf.bean;

public class User {
    private String name;
    private String gender;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User(String name, String gender, Integer id) {
        this.name = name;
        this.gender = gender;
        this.id = id;
    }
}
