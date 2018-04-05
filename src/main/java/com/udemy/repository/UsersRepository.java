package com.udemy.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.entity.Users;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<Users, Serializable> {

}
