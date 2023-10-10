package com.services.mySqlDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class NumbersDbController {

    @Autowired
    NumberDatabase numberDatabase;

    @GetMapping("/getNumbers")
    public ArrayList<Numbers> getNumbers() {
        return (ArrayList<Numbers>) numberDatabase.findAll();
    }

    @PostMapping("/addNumber")
    public void addNumber(@RequestBody ArrayList<Numbers> numbers) {
        System.out.println(numbers);
        numberDatabase.saveAll(numbers);
    }
}
