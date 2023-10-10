package com.example.analytics;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Analyzer {
    int sum, max, min, mode, size, range;
    double average, median, squaredSum, variance, standardDeviation;
    ArrayList<Integer> numbers;

    public Analyzer() {
        this.numbers = new ArrayList<>();
        this.numbers.add(0);
        doAnalysis();
        size = 0;
    }

    public void DataAnalysis(ArrayList<Integer> numbers){
        this.numbers = numbers;
        doAnalysis();
    }

    private void doAnalysis() {
        Collections.sort(numbers);

        size = numbers.size();
        max = Collections.max(numbers);
        min = Collections.min(numbers);

        sum = 0;
        for (int number : numbers)
            sum += number;

        average = (double) sum / size;

        if (numbers.size() % 2 == 0)
            median = (double) (numbers.get(size / 2 - 1) + numbers.get(size / 2)) / 2;
        else
            median = numbers.get(size / 2);

        range = max - min;

        squaredSum = 0.0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int value : numbers) {
            squaredSum += Math.pow(value - average, 2);
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        variance = squaredSum / (size - 1);
        standardDeviation = Math.sqrt(variance);
        mode = Collections.max(frequencyMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public int getSum() {
        return sum;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public int getMode() {
        return mode;
    }

    public int getSize() {
        return size;
    }

    public int getRange() {
        return range;
    }

    public double getAverage() {
        return average;
    }

    public double getMedian() {
        return median;
    }

    public double getSquaredSum() {
        return squaredSum;
    }

    public double getVariance() {
        return variance;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    @Override
    public String toString() {
        return "Analyzer{" +
                "sum=" + sum +
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
                ", numbers=" + numbers +
                '}';
    }
}
