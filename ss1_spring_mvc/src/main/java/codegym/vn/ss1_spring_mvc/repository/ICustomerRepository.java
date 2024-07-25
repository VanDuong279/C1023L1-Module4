package codegym.vn.ss1_spring_mvc.repository;

import codegym.vn.ss1_spring_mvc.model.Customer;

import java.util.List;
public interface ICustomerRepository {
    public List<Customer> findAll();
}
