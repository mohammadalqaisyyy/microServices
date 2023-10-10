package com.example.enterData;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Controller
@RequestMapping("/enterData")
public class EnterDataController {

    @GetMapping
    public String showEnterDataPage(HttpSession session) {
        if (session.getAttribute("loggedInUser") != null && (boolean) session.getAttribute("loggedInUser")) {
            return "enterData";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping
    public String enterData(@RequestParam("data") ArrayList<String> readNumbers, Model model) {
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            for (String str : readNumbers) {
                if (!str.isEmpty())
                    numbers.add(Integer.valueOf(str));
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Invalid Data!!");
            return "enterData";
        }

        ArrayList<Numbers> numbersList = new ArrayList<>();
        for(Integer num : numbers){
            Numbers n = new Numbers();
            n.setNumber(num);
            numbersList.add(n);
        }

        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://mysql-db-service:8083/addNumber";

        System.out.println(numbersList);

        restTemplate.postForEntity(apiUrl, numbersList, Object.class);

        System.out.println(numbers);
        return "redirect:/enterData";
    }
}