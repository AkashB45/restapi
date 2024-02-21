package com.example.grigo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.grigo.model.Grocery;
import com.example.grigo.model.Users;
import com.example.grigo.service.GroceryService;

@RestController
public class GroceryController {
    @Autowired
    GroceryService groceryService;

    @PostMapping("/add")
    public ResponseEntity<Grocery> postMethod(@RequestBody Grocery grocery)
    {
        return new ResponseEntity<>(groceryService.postGrocery(grocery),HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public List<Grocery> getMethod()
    {
        return groceryService.getGrocery();
    }
    @GetMapping("/get/{id}")
    public Optional<Grocery> getMethodbyId(@PathVariable Long id)
    {
        return groceryService.getGrocerybyId(id);
    }
    @PutMapping("/put/{id}")
    public Grocery putMethod(@PathVariable Long id,@RequestBody Grocery grocery)
    {
        return groceryService.putGrocery(id, grocery);
    }
    @DeleteMapping("/del/{id}")
    public String delMethod(@PathVariable Long id)
    {
        return groceryService.deletGrocery(id);
    }
    @GetMapping("/bytype")
    public List<Grocery> getbyType(@RequestParam(name = "type") String type)
    {
        return groceryService.getGrocerybyType(type);
    }
    @PostMapping("/useradd")
    public Users postMethodUsers(Users user)
    {
        return groceryService.postUser(user);
    }
    @GetMapping("/user")
    public List<Users> getMetodUsers()
    {
        return groceryService.getUser();
    }
    @GetMapping("/user/{id}")
    public Optional<Users> getMetodUsersbyId(Long id)
    {
        return groceryService.getUserbyId(id);
    }
    @PutMapping("/userput/{id}")
    public Users putMtehodUsers(Long id,Users user)
    {
        return groceryService.putUser(id, user);
    }
    @DeleteMapping("/userdel")
    public String delMethodUsers(Long id)
    {
        return groceryService.deleteUser(id);
    }
    @GetMapping("/username")
    public List<Users> getByusername(@RequestParam(name="Uname") String name)
    {
        return groceryService.getUsername(name);
    }

}
