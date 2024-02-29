package com.example.grigo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserTable")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userid;
    String username;
    String userpass;
    String usermailid;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="users_id")
    List<Grocery> groceries = new ArrayList<>();
    public Long getUserid() {
        return userid;
    }
    public void setUserid(Long userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserpass() {
        return userpass;
    }
    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }
    public String getUsermailid() {
        return usermailid;
    }
    public void setUsermailid(String usermailid) {
        this.usermailid = usermailid;
    }
    public List<Grocery> getGroceries() {
        return groceries;
    }
    public void setGroceries(List<Grocery> groceries) {
        this.groceries = groceries;
    }
    
    
    
}
