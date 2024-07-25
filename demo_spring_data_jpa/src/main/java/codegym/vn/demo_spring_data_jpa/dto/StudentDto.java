package codegym.vn.demo_spring_data_jpa.dto;


import codegym.vn.demo_spring_data_jpa.model.Classes;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentDto implements Validator {

    @NotEmpty(message = "Not Empty")
    @Pattern(regexp = "^[A-Z][a-z]*$", message = "Not match")
    private String name;
    private boolean gender;
    private Classes classes;


//    @NotNull(message = "ten lop phai co")
//    private String className;

//    public String getClassName() {
//        return className;
//    }
//
//    public void setClassName(String className) {
//        this.className = className;
//    }

    public StudentDto() {
    }

    public StudentDto(String name, boolean gender) {
        this.name = name;
        this.gender = gender;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDto studentDto = (StudentDto) target;
        if (studentDto.getName().equals("")) {

            errors.rejectValue("name",null,"Not Empty");
        }else if (!studentDto.getName().matches("^[A-Z][a-z]*")){

            errors.rejectValue("name",null,"Not Match");
        }
    }
}

