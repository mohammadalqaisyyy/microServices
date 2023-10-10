package com.services.mangoDB;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalysisDbController {

    @Autowired
    private AnalysisDatabase analysisDatabase;

    @GetMapping("/getData")
    public AnalysisData getNumbers() {
        return analysisDatabase.findAll().get(0);
    }

    @PostMapping("/saveData")
    public void saveData(@RequestBody AnalysisData analysisData) {
        System.out.println(analysisData.toString());
        analysisDatabase.deleteAll();
        analysisDatabase.save(analysisData);
    }
}
