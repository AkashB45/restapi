package com.example.grigo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.grigo.model.Users;
import com.example.grigo.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    
    public final UserService userservice;

     @PostMapping("/adduser")
    public Users postMethodUsers(@RequestBody Users user)
    {
        return userservice.postUser(user);
    }
    @GetMapping("/user")
    public List<Users> getMetodUsers()
    {
        return userservice.getUser();
    }
    @GetMapping("/user/{id}")
    public Optional<Users> getMetodUsersbyId(@PathVariable Long id)
    {
        return userservice.getUserbyId(id);
    }
    @GetMapping("user/get/sort/{field}")
    public List<Users> getMethodbySort(@PathVariable String field)
    {
        return userservice.getBySortedbyName(field);
    }
    @GetMapping("user/get/page/{no}/{size}")
    public List<Users> getMethodbyPage(@PathVariable int no,@PathVariable int size)
    {
        return userservice.getByPaging(no, size);
    }
    @GetMapping("user/get/pageandsort/{field}/{no}/{size}")
    public List<Users> getMethodbySortandPage(@PathVariable String field,@PathVariable int no,@PathVariable int size)
    {
        return userservice.getBySortandPages(field,no,size);
    }
    @PutMapping("/uput/{id}")
    public Users putMtehodUsers(@PathVariable Long id,@RequestBody Users user)
    {
        return userservice.putUser(id, user);
    }
    @DeleteMapping("/userdel/{id}")
    public String delMethodUsers(@PathVariable Long id)
    {
        return userservice.deleteUser(id);
    }
    @GetMapping("/username")
    public List<Users> getByusername(@RequestParam(name="Uname") String name)
    {
        return userservice.getUsername(name);
    }

}
