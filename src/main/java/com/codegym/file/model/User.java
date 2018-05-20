package com.codegym.file.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String avatar;

    @Column
    private String originAvatarName;

    public User() {
    }

    public User(String name, String avatar, String originAvatarName) {
        this.name = name;
        this.avatar = avatar;
        this.originAvatarName = originAvatarName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getOriginAvatarName() {
        return originAvatarName;
    }

    public void setOriginAvatarName(String originAvatarName) {
        this.originAvatarName = originAvatarName;
    }
}
