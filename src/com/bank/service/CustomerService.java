package com.bank.service;

import com.bank.customer.Customer;

public interface CustomerService {
    Customer addCustomer(String name, String phone, String address);
    Customer getCustomer(int customerId) throws Exception;
    Customer updateCustomer(int customerId, String name, String phone, String address) throws Exception;
    Customer updateName(int customerId, String name) throws Exception;
    Customer updatePhone(int customerId, String phone) throws Exception;
    Customer updateAddress(int customerId, String address) throws Exception;
    String deleteCustomer(int customerId) throws Exception;
    void listCustomers();
}