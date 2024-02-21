package com.example.grigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.grigo.model.Grocery;

@SuppressWarnings("unused")
@Repository
public interface GroceryRepo extends JpaRepository<Grocery,Long>,PagingAndSortingRepository<Grocery,Long>
{

    List<Grocery> findByGrocerytype(String grocerytype);
}