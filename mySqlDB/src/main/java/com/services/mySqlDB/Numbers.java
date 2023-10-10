package com.services.mySqlDB;

import jakarta.persistence.*;

@Entity
public class Numbers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
