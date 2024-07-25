package codegym.vn.demo_spring_data_jpa.controller;

import codegym.vn.demo_spring_data_jpa.AdminException;
import codegym.vn.demo_spring_data_jpa.dto.StudentDto;
import codegym.vn.demo_spring_data_jpa.model.Student;
import codegym.vn.demo_spring_data_jpa.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    //    @GetMapping(value = "")
//    public ModelAndView showList(@PageableDefault(page = 0,size = 2,sort = "name",direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(defaultValue = "") String searchName){
//        ModelAndView modelAndView = new ModelAndView("list");
//        Page<Student> studentPage = studentService.findAll(pageable);
//        modelAndView.addObject("studentPage",studentPage);
//        return modelAndView;
//    }
//
    @GetMapping(value = "")
    public ModelAndView showList(@RequestParam(required = false,defaultValue = "0") int page,
                                 @RequestParam(required = false,defaultValue = "1") int size,
                                 @RequestParam(defaultValue = "") String searchName){
        System.out.println("------------showList run---------------");
        ModelAndView modelAndView = new ModelAndView("list");
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Student> studentPage = studentService.search(searchName,pageable);
        modelAndView.addObject("studentPage",studentPage);
        modelAndView.addObject("searchName", searchName);
        return modelAndView;
    }


    @GetMapping(value = "/detail")
    public String detail(@RequestParam(name = "id",required = false,defaultValue = "2") int id1 ,Model model){
        Student student = studentService.findById(id1);
        model.addAttribute("student", student);
        return "detail";
    }
    @GetMapping(value = "/detail/{id}")
    public String detail2(@PathVariable int id , Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "detail";
    }
    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("studentDto", new StudentDto());
        return "create";
    }
    @PostMapping("/create")
    public String save(@Validated @ModelAttribute StudentDto studentDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) throws AdminException {


        new StudentDto().validate(studentDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        System.out.println(4/0);
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        studentService.save(student);
        redirectAttributes.addFlashAttribute("mess","Add  new success");
        System.out.println("------------save done-----------");
        return "redirect:/students";
    }

    @ExceptionHandler(AdminException.class)
    public String handleAdminException(){
        return "admin-exception";
    }

    @ExceptionHandler(Exception.class)
    public String handleExcepiton(){
        return "errors";
    }


}

