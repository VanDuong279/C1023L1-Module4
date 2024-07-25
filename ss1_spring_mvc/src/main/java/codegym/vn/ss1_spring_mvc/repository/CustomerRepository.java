package codegym.vn.ss1_spring_mvc.repository;

import codegym.vn.ss1_spring_mvc.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository {
    public static List<Customer> list = new ArrayList<>();
    static {
        list.add(new Customer(1,"VanDuong","vanduong27904@gmail.com","Hong Kong"));
        list.add(new Customer(2,"VanDuong","vanduong27904@gmail.com","Hong Kong"));
        list.add(new Customer(3,"VanDuong","vanduong27904@gmail.com","Hong Kong"));
        list.add(new Customer(4,"VanDuong","vanduong27904@gmail.com","Hong Kong"));
    }
    @Override

    public List<Customer> findAll() {
        return list;
    }
}
