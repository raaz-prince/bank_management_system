package com.bank.customer;

public class Customer {
    private static int idCounter = 1000;
    private int customerId;
    private String name;
    private String phone;
    private String address;
    private boolean kycVerified;

    public Customer(String name, String phone, String address) {
        this.customerId = ++idCounter;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.kycVerified = false;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isKycVerified() {
        return kycVerified;
    }

    public void verifyKYC() {
        this.kycVerified = true;
    }

    @Override
    public String toString() {
        return """
           Customer{
               customerId= %d,
               name= '%s',
               phone= '%s',
               address= '%s',
               kycVerified= %s
           }
           """.formatted(customerId, name, phone, address, kycVerified);
    }

}
