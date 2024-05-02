package com.kwonjh0406.blog.repository;

import com.kwonjh0406.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
