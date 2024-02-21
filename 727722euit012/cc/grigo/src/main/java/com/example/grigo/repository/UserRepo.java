package com.example.grigo.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.grigo.model.Users;

@SuppressWarnings("unused")
@Repository
public interface UserRepo extends JpaRepository<Users,Long>,PagingAndSortingRepository<Users,Long>{

    List<Users> findByUsername(String name);
}
