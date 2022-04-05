package com.demp.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demp.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}
