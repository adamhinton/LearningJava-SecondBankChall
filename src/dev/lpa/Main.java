package dev.lpa;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }
}


class Bank{
    private String name;
    private ArrayList<Branch> branches;
}

class Branch {
    private String name;
    private ArrayList<Customer> customers;
}

class Customer{
    private String name;
    private ArrayList<Double> transactions;
}