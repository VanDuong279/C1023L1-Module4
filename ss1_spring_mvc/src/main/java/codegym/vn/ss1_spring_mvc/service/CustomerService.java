package codegym.vn.ss1_spring_mvc.service;

import codegym.vn.ss1_spring_mvc.model.Customer;
import codegym.vn.ss1_spring_mvc.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    public static CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
