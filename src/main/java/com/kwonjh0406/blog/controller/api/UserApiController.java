package com.kwonjh0406.blog.controller.api;

import com.kwonjh0406.blog.dto.ResponseDto;
import com.kwonjh0406.blog.model.RoleType;
import com.kwonjh0406.blog.model.User;
import com.kwonjh0406.blog.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    UserService userService;

    @Autowired
    HttpSession session;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("호출됨");
        user.setRole(RoleType.USER);
        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping("api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user) {
        System.out.println("호출됨");
        User principal = userService.로그인(user);
        if (principal != null) {
            session.setAttribute("principal", principal);
        } else {
            return new ResponseDto<Integer>(404, 1);
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);

    }
}
