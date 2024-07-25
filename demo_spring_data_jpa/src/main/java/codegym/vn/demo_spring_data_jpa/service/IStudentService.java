package codegym.vn.demo_spring_data_jpa.service;

import codegym.vn.demo_spring_data_jpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable);
    List<Student> search(String searchName);
    Page<Student> search(String searchName,Pageable pageable);
    Student findById(int id);
    void save(Student student);
    void delete(Student student);
}
