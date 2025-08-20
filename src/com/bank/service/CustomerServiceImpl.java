package com.bank.service;

import com.bank.customer.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService{
    Map<Integer, Customer> customers = new HashMap<>();
    @Override
    public Customer addCustomer(String name, String phone, String address) {
        Customer customer = new Customer(name, phone, address);
        customers.put(customer.getCustomerId(), customer);
        return customer;
    }

    @Override
    public Customer getCustomer(int customerId) throws Exception {
        Customer customer = customers.get(customerId);
        if(customer == null)
            throw new Exception("Customer not found");
        return customer;
    }

    @Override
    public Customer updateCustomer(int customerId, String name, String phone, String address) throws Exception {
        Customer customer = customers.get(customerId);
        if(customer == null)
            throw new Exception("customer not found with Id: " + customerId);
        customer.setName(name);
        customer.setAddress(address);
        customer.setPhone(phone);
        return customer;
    }

    @Override
    public Customer updateName(int customerId, String name) throws Exception {
        Customer customer = customers.get(customerId);
        if(customer == null)
            throw new Exception("customer not found with Id: " + customerId);
        customer.setName(name);
        return customer;
    }

    @Override
    public Customer updatePhone(int customerId, String phone) throws Exception {
        Customer customer = customers.get(customerId);
        if(customer == null)
            throw new Exception("customer not found with Id: " + customerId);
        customer.setPhone(phone);
        return customer;
    }

    @Override
    public Customer updateAddress(int customerId, String address) throws Exception {
        Customer customer = customers.get(customerId);
        if(customer == null)
            throw new Exception("customer not found with Id: " + customerId);
        customer.setAddress(address);
        return customer;
    }

    @Override
    public String deleteCustomer(int customerId) throws Exception {
        Customer customer = customers.remove(customerId);
        if(customer == null)
            throw new Exception("Customer not found");
        return "Sucessfully deleted.";
    }

    @Override
    public void listCustomers() {
        customers.values().forEach(System.out::println);
    }
}