package com.example.grigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.grigo.model.Users;
import com.example.grigo.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;


        @SuppressWarnings("null")
    public Users postUser(Users user)
    {
        return userRepo.save(user);
    }
    public List<Users> getUser()
    {
        return userRepo.findAll();
    }
    @SuppressWarnings("null")
    public Optional<Users> getUserbyId(Long id)
    {
        return userRepo.findById(id);
    }
    @SuppressWarnings("null")
    public Users putUser(Long id,Users user)
    {
          Users userAvail = userRepo.findById(id).orElse(null);
          if(userAvail!=null)
          {
            userAvail.setUsername(user.getUsername());
            userAvail.setUserpass(user.getUserpass());
            userAvail.setUsermailid(user.getUsermailid());
            userAvail.setGroceries(user.getGroceries());
            return userRepo.saveAndFlush(userAvail);
          }
          else
          return null;
    }
    @SuppressWarnings("null")
    public String deleteUser(Long id)
    {
        userRepo.deleteById(id);
        return "User DELETED";
    }
    public List<Users> getUsername(String name)
    {
        return userRepo.getUserByName(name);
    }

    public List<Users> getBySortedbyName(String field)
    {
        Sort sort = Sort.by(Sort.Direction.ASC,field);
        return userRepo.findAll(sort);
    }
    public List<Users> getByPaging(int pgno,int pgsize)
    {
        Pageable page = PageRequest.of(pgno, pgsize);
        return userRepo.findAll(page).getContent();
    }
    public List<Users> getBySortandPages(String field,int no,int size)
    {
        return userRepo.findAll(PageRequest.of(no, size).withSort(Sort.Direction.ASC,field)).getContent();
    }

}
