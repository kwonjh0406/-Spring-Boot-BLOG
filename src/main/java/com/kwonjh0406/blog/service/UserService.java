package com.kwonjh0406.blog.service;

import com.kwonjh0406.blog.model.User;
import com.kwonjh0406.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int 회원가입(User user){
        try{
            userRepository.save(user);
            return 1;
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("UserService : 회원가입() : "+e.getMessage());
        }
        return -1;
    }
}
