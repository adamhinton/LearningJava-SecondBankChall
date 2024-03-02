package dev.lpa;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }
}


class Bank{
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String newBranchName){
        Branch existingBranch = findBranch(newBranchName);

        // Branch doesn't exist so adding new Branch
        if(existingBranch != null){
            addBranch(newBranchName);
            return true;
        }

        // Branch already exists
        else{
            return false;
        }
    }

    public boolean addCustomer (String branchName, String newCustomerName, Double initialTransactionAmount){
        
        Branch existingBranch = findBranch(branchName);
        
        // Can't find branch, exit out
        if(existingBranch == null){
            return false;
        }
        
        boolean didAddNewCustomer = existingBranch.addCustomerTransaction(newCustomerName, initialTransactionAmount);
        
        // Boolean of whether new CR was added or not
        // False if customer already exists
        return didAddNewCustomer;
        
    }
    
    private Branch findBranch(String branchName){
        // Found branch
        for (Branch branch : branches){
            if(branch.getName() == branchName){
                return branch;
            }
        }
        // Couldn't find branch
        return null;
    }
}

class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String newCustomerName, double transactionAmount){
        // Happy path, customer doesn't exist in db
       if(findCustomer(newCustomerName)==null){
           Customer newCustomer = new Customer(newCustomerName, transactionAmount);
           customers.add(newCustomer);
           return true;
       }
       // Customer already exists
       return false;
    }

    public boolean addCustomerTransaction(String customerName, double transactionAmount){

        // Happy path, found customer
        Customer customer = findCustomer(customerName);
        if(customer != null){
            customer.addTransaction(transactionAmount);
            return true;
        }

        // Sad path, couldn't find customer
        return false;
    }


    private Customer findCustomer(String customerName){
        for (Customer customer : customers){
            if(customer.getName() == customerName){
                return customer;
            }
        }
        return null;
    }

}

class Customer{
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, Double initialTransaction) {
        this.name = name;
        transactions = new ArrayList<Double>();
        transactions.add(initialTransaction);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(Double transactionAmount){
        transactions.add(transactionAmount);
    }
}