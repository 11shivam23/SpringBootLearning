package com.springboot.web.repository;

import org.springframework.data.repository.CrudRepository;
import com.springboot.web.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
    
}
