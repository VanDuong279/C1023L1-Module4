package codegym.vn.demo_spring_data_jpa.controller;


import codegym.vn.demo_spring_data_jpa.dto.StudentDto;
import codegym.vn.demo_spring_data_jpa.model.Student;
import codegym.vn.demo_spring_data_jpa.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class RestStudentController {
    @Autowired
    private IStudentService studentService;
//    @GetMapping("")
//    public ResponseEntity<List<Student>> getList(){
//        List<Student> studentList = studentService.findAll();
//        if (studentList.isEmpty()){
//            return  new ResponseEntity<>(studentList,HttpStatus.NO_CONTENT);// 204
//        }
//        return new ResponseEntity<>(studentList,HttpStatus.OK); // 200
//    }
    @GetMapping("")
    public  ResponseEntity<Page<Student>> getList(Pageable pageable) {
        Page<Student> studentPage = studentService.findAll(pageable);
        if (studentPage.isEmpty()) {
            return new ResponseEntity<>(studentPage,HttpStatus.NO_CONTENT); // 204
        }
        return new ResponseEntity<>(studentPage,HttpStatus.OK); // 200
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable int id){
        Student student = studentService.findById(id);
        if (student==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);// 404
        }
        return new ResponseEntity<>(student,HttpStatus.OK); // 200
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody @Valid StudentDto studentDto, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED); // 201
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Student  student = studentService.findById(id);
        if (student==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
        }
        studentService.delete(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping ("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody StudentDto studentDto){
        Student  student = studentService.findById(id);
        if (student==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
        }
        BeanUtils.copyProperties(studentDto,student);
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
