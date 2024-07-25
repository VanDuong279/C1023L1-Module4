package codegym.vn.demo_spring_data_jpa.service;

import codegym.vn.demo_spring_data_jpa.model.Student;
import codegym.vn.demo_spring_data_jpa.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository repository;
    @Override
    public List<Student> findAll() {
       return repository.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
       return repository.findAll(pageable);
    }

    @Override
    public List<Student> search(String searchName) {
        return repository.searchByName("%"+searchName+"%");
    }

    @Override
    public Page<Student> search(String searchName, Pageable pageable) {
        return repository.findStudentByNameContaining(searchName,pageable);
    }

    @Override
    public Student findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public void delete(Student student) {
        repository.delete(student);
    }
}
