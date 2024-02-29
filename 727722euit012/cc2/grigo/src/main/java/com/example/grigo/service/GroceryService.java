package com.example.grigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.grigo.model.Grocery;
import com.example.grigo.repository.GroceryRepo;

@Service
public class GroceryService {
    @Autowired
    GroceryRepo groceryrepo;
    
    
    @SuppressWarnings("null")
    public Grocery postGrocery(Grocery grocery)
    {
        return groceryrepo.save(grocery);
    }
    @SuppressWarnings("null")
    public List<Grocery> postGroceryAll(List<Grocery> grocery)
    {
        return groceryrepo.saveAll(grocery);
    }
    public List<Grocery> getGrocery()
    {
        return groceryrepo.findAll();
    }
    @SuppressWarnings("null")
    public Optional<Grocery> getGrocerybyId(Long id)
    {
        return groceryrepo.findById(id);
    }
    @SuppressWarnings("null")
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
    @SuppressWarnings("null")
    public String deletGrocery(Long id)
    {
         groceryrepo.deleteById(id);
         return ("ID Number "+id+" data deleted");
    }

    public List<Grocery> getGrocerybyType(String grocerytype)
    {
        return groceryrepo.findByGrocerytype(grocerytype);
    }
    public List<Grocery> getBySortedbyName(String field)
    {
        Sort sort = Sort.by(Sort.Direction.ASC,field);
        return groceryrepo.findAll(sort);
    }
    public List<Grocery> getByPaging(int pgno,int pgsize)
    {
        Pageable page = PageRequest.of(pgno, pgsize);
        return groceryrepo.findAll(page).getContent();
    }
    public List<Grocery> getBySortandPages(String field,int no,int size)
    {
        return groceryrepo.findAll(PageRequest.of(no, size).withSort(Sort.Direction.ASC,field)).getContent();
    }



}
