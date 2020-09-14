package com.api.backend.models.users;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
@Data
@Entity
@Table(name="Users")
public class Users {


    private @Id @GeneratedValue long id;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    private Integer userId;
    private String name;
    private String email;
    private String password;


    public Users(){

    }

    public Users(Timestamp createdAt, String name, String email, String password) {
        this.createdAt = createdAt;
        this.name = name;
        this.email = email;
        this.password =password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
