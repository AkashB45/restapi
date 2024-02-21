package com.example.grigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grigo.model.Grocery;
import com.example.grigo.model.Users;
import com.example.grigo.repository.GroceryRepo;
import com.example.grigo.repository.UserRepo;

@Service
public class GroceryService {
    @Autowired
    GroceryRepo groceryrepo;
    @Autowired
    UserRepo userRepo;
    public Grocery postGrocery(Grocery grocery)
    {
        return groceryrepo.save(grocery);
    }
    public List<Grocery> getGrocery()
    {
        return groceryrepo.findAll();
    }
    public Optional<Grocery> getGrocerybyId(Long id)
    {
        return groceryrepo.findById(id);
    }
    public Grocery putGrocery(Long id,Grocery grocery)
    {
        Grocery groceryAvail = groceryrepo.findById(id).orElse(null);
        if(groceryAvail!=null)
        {
            groceryAvail.setGroceryname(grocery.getGroceryname());
            groceryAvail.setGrocerytype(grocery.getGrocerytype());
            groceryAvail.setPrice(grocery.getPrice());
            return groceryrepo.saveAndFlush(groceryAvail);           
        }
        else 
        return null;
    }
    public String deletGrocery(Long id)
    {
         groceryrepo.deleteById(id);
         return ("ID Number "+id+" data deleted");
    }

    public List<Grocery> getGrocerybyType(String grocerytype)
    {
        return groceryrepo.findByGrocerytype(grocerytype);
    }
    
    public Users postUser(Users user)
    {
        return userRepo.save(user);
    }
    public List<Users> getUser()
    {
        return userRepo.findAll();
    }
    public Optional<Users> getUserbyId(Long id)
    {
        return userRepo.findById(id);
    }
    public Users putUser(Long id,Users user)
    {
          Users userAvail = userRepo.findById(id).orElse(null);
          if(userAvail!=null)
          {
            userAvail.setUserid(user.getUserid());
            userAvail.setUserpass(user.getUserpass());
            userAvail.setUsermailid(user.getUsermailid());
            return userRepo.saveAndFlush(userAvail);
          }
          else
          return null;
    }
    public String deleteUser(Long id)
    {
        userRepo.deleteById(id);
        return "User DELETED";
    }
    public List<Users> getUsername(String name)
    {
        return userRepo.findByUsername(name);
    }
    


}
