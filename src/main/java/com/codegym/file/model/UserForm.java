package com.codegym.file.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

public class UserForm {

    private String name;

    private MultipartFile avatar;

    public UserForm() {
    }

    public UserForm(String name, MultipartFile avatar) {
        this.name = name;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}
