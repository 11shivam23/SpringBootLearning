package com.springboot.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.web.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
    
    public List<UserModel> findByName(String name);

    public List<UserModel> findByNameAndCity(String name, String city);

    public List<UserModel> findByNameStartingWith(String prefix);

    public List<UserModel> findByNameEndingWith(String suffix);

    public List<UserModel> findByNameContaining(String words);

    public List<UserModel> findByNameLike(String likePattern);

    // public List<UserModel> findByAgeLessThan(int age);

    // public List<UserModel> findByAgeGreaterThan(int age);

    // public List<UserModel> findByAgeIn(List<Integer> ages);

    // public List<UserModel> findByNameOrderByName(String name);

    @Query("SELECT u FROM UserModel u")
    public List<UserModel> getAllUser();

    @Query("SELECT u FROM UserModel u WHERE u.name =:n")
    public List<UserModel> getUserByName(@Param("n") String name);

    @Query(value = "SELECT * FROM user_model", nativeQuery = true)
    public List<UserModel> getUsers();

}
