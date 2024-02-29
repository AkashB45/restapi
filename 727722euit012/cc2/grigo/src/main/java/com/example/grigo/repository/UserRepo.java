package com.example.grigo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.grigo.model.Users;

@SuppressWarnings("unused")
@Repository
public interface UserRepo extends JpaRepository<Users,Long>,PagingAndSortingRepository<Users,Long>{

    List<Users> findByUsername(String name);

    @Query("select u from Users u where u.id=?1")
    Optional<Users> findByIdOptional(Long id);

    @Query(value = "Select * from user_table u join grocery g on u.userid = g.users_id where u.username like :name limit 1",nativeQuery = true)
    List<Users> getUserByName(@Param("name") String name);

    
}
