package com.vid.springboot.java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vid.springboot.java.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserId(int id);

}
