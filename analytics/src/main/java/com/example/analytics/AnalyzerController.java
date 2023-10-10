package com.example.analytics;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
import java.util.ArrayList;

@Component
public class AnalyzerController {
    Analyzer analyzer;
    AnalysisData analysisData;
    RestTemplate restTemplate;
    ArrayList<Integer> numbers;
    ArrayList<Numbers> data;
    String apiUrl;
    private static int sizeOfData;

    public AnalyzerController() throws ConnectException, InterruptedException {
        this.numbers = new ArrayList<>();
        analyzer = new Analyzer();
        analysisData = new AnalysisData();
        data = new ArrayList<>();
        sizeOfData = 0;
        restTemplate = new RestTemplate();
        apiUrl = "http://mongo-db-service:8085/saveData";
        restTemplate.postForEntity(apiUrl, analysisData, Object.class);
        check();
        updateAnalysisData();
    }

    @Scheduled(fixedRate = 1000)
    public void check() throws InterruptedException {
        try {
            getData();
        } catch (Exception e) {
            System.out.println("Error in MySQL Database: " + e.getMessage());
        }
        if (sizeOfData != data.size()) {
            System.out.println("There is a new data, new size = " + data.size());
            numbers.clear();
            for (Numbers num : data)
                numbers.add(num.getNumber());
            analyzer.DataAnalysis(numbers);
            updateAnalysisData();
            sizeOfData = data.size();
        }
    }

    private void updateAnalysisData() {
        analysisData.setSize(analyzer.getSize());
        analysisData.setAverage(analyzer.getAverage());
        analysisData.setMax(analyzer.getMax());
        analysisData.setMin(analyzer.getMin());
        analysisData.setMode(analyzer.getMode());
        analysisData.setMedian(analyzer.getMedian());
        analysisData.setRange(analyzer.getRange());
        analysisData.setSquaredSum(analyzer.getSquaredSum());
        analysisData.setStandardDeviation(analyzer.getStandardDeviation());
        analysisData.setVariance(analyzer.getVariance());
        analysisData.setSum(analyzer.getSum());
        try{
            restTemplate.postForEntity(apiUrl, analysisData, Object.class);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    private void getData() throws ConnectException {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://mysql-db-service:8083/getNumbers";

        ResponseEntity<ArrayList<Numbers>> response;
        try {
            response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );
        } catch (Exception e) {
            throw new ConnectException("Cannot connect to MySQL database");
        }
        data = response.getBody();
    }
}
