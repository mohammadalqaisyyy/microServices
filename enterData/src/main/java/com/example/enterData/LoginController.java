package com.example.enterData;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping
    public String showLoginPage() {
        return "login";
    }

    @PostMapping
    public String authenticate(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://authentication-service:8081/auth/login";

        User user = new User(username, password);

        ResponseEntity<Boolean> response = restTemplate.postForEntity(apiUrl, user, Boolean.class);
        boolean isAuthenticated = Boolean.TRUE.equals(response.getBody());

        if (isAuthenticated) {
            session.setAttribute("loggedInUser", true);
            return "redirect:/enterData";
        }
        model.addAttribute("errorMessage", "Invalid Credentials!!");
        return "login";
    }
}
