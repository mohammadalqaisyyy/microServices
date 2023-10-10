package com.services.mangoDB;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "analysisData")
public class AnalysisDataDocument {
    @Id
    private String id;

    private int sum;
    private int max;
    private int min;
    private int mode;
    private int size;
    private int range;

    private double average;
    private double median;
    private double squaredSum;
    private double variance;
    private double standardDeviation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public double getSquaredSum() {
        return squaredSum;
    }

    public void setSquaredSum(double squaredSum) {
        this.squaredSum = squaredSum;
    }

    public double getVariance() {
        return variance;
    }

    public void setVariance(double variance) {
        this.variance = variance;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    @Override
    public String toString() {
        return "AnalysisDataDocument{" +
                "id='" + id + '\'' +
                ", sum=" + sum +
                ", max=" + max +
                ", min=" + min +
                ", mode=" + mode +
                ", size=" + size +
                ", range=" + range +
                ", average=" + average +
                ", median=" + median +
                ", squaredSum=" + squaredSum +
                ", variance=" + variance +
                ", standardDeviation=" + standardDeviation +
                '}';
    }
}
