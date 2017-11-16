package com.home.vo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {
    private int id;
    private String userno;
    private String password;
    private String name;
    private Collection<Kaiguang> kaiguangsById;
    private Collection<Kongtiao> kongtiaosById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userno", nullable = false, length = 11)
    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 1000)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (userno != null ? !userno.equals(user.userno) : user.userno != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userno != null ? userno.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserW")
    public Collection<Kaiguang> getKaiguangsById() {
        return kaiguangsById;
    }

    public void setKaiguangsById(Collection<Kaiguang> kaiguangsById) {
        this.kaiguangsById = kaiguangsById;
    }

    @OneToMany(mappedBy = "userByUserW")
    public Collection<Kongtiao> getKongtiaosById() {
        return kongtiaosById;
    }

    public void setKongtiaosById(Collection<Kongtiao> kongtiaosById) {
        this.kongtiaosById = kongtiaosById;
    }
}
