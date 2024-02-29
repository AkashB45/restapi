package com.example.grigo.controller;

import java.util.List;
import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.grigo.service.GroceryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GroceryController {
    
    public final GroceryService groceryService;

    @PostMapping("/add")
    public ResponseEntity<Grocery> postMethod(@RequestBody Grocery grocery)
    {
        return new ResponseEntity<>(groceryService.postGrocery(grocery),HttpStatus.CREATED);
    }
    @PostMapping("/addAll")
    public ResponseEntity<?> postAllMethod(@RequestBody List<Grocery> grocery)
    {
        return new ResponseEntity<>(groceryService.postGroceryAll(grocery),HttpStatus.CREATED);
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
    @GetMapping("/get/sort/{field}")
    public List<Grocery> getMethodbySort(@PathVariable String field)
    {
        return groceryService.getBySortedbyName(field);
    }
    @GetMapping("/get/page/{no}/{size}")
    public List<Grocery> getMethodbyPage(@PathVariable int no,@PathVariable int size)
    {
        return groceryService.getByPaging(no, size);
    }
    @GetMapping("/get/pageandsort/{field}/{no}/{size}")
    public List<Grocery> getMethodbySortandPage(@PathVariable String field,@PathVariable int no,@PathVariable int size)
    {
        return groceryService.getBySortandPages(field,no,size);
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
   
}
