package com.services.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping("/login")
    public ResponseEntity<Boolean> authenticate(@RequestBody User user) {
        boolean isValid = UserDao.checkUser(user.getUsername(), user.getPassword());
        System.out.println("username : " + user.getUsername() + " - password : " + user.getPassword() + " = " + isValid);
        return ResponseEntity.ok(isValid);
    }

}
