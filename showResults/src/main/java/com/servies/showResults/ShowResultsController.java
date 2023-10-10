package com.servies.showResults;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
import java.util.ArrayList;

@Controller
@RequestMapping("/showResults")
public class ShowResultsController {

    @GetMapping
    public String showResultsPage(Model model) throws ConnectException {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://mongo-db-service:8085/getData";
        AnalysisData data;
        ResponseEntity<AnalysisData> response;
        try {
            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );
        } catch (Exception e) {
            throw new ConnectException("Cannot connect to MangoDB database");
        }

        data = response.getBody();
        System.out.println(data);
        ArrayList<String> result = new ArrayList<>();
        assert data != null;

        result.add("# of Numbers : " + data.getSize());
        result.add("Sum : " + data.getSum());
        result.add("Min : " + data.getMin());
        result.add("Max : " + data.getMax());
        result.add("Range : " + data.getRange());
        result.add("Mode : " + data.getMode());
        result.add("Average : " + data.getAverage());
        result.add("Median : " + data.getMedian());
        result.add("Squared Sum : " + data.getSquaredSum());
        result.add("Variance : " + data.getVariance());
        result.add("Standard Deviation : " + data.getStandardDeviation());

        model.addAttribute("results", result);

        return "showResults";
    }
}
