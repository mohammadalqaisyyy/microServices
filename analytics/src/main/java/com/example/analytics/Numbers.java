package com.example.analytics;

public class Numbers {
    private long id;

    int number;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}
