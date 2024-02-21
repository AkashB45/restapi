package com.example.grigo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Grocery")
public class Grocery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long groceryid;
    String groceryname;
    String grocerytype;
    double price;
    public Long getGroceryid() {
        return groceryid;
    }
    public void setGroceryid(Long groceryid) {
        this.groceryid = groceryid;
    }
    public String getGroceryname() {
        return groceryname;
    }
    public void setGroceryname(String groceryname) {
        this.groceryname = groceryname;
    }
    public String getGrocerytype() {
        return grocerytype;
    }
    public void setGrocerytype(String grocerytype) {
        this.grocerytype = grocerytype;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
}
