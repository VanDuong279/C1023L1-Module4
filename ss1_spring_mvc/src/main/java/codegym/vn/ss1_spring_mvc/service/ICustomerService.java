package codegym.vn.ss1_spring_mvc.service;

import codegym.vn.ss1_spring_mvc.model.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> findAll();
}
