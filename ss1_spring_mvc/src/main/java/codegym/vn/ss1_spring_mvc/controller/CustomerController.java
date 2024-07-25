package codegym.vn.ss1_spring_mvc.controller;

import codegym.vn.ss1_spring_mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    public CustomerService dao;
    @GetMapping("/customer")
    public String showListCus(Model model) {
        model.addAttribute("listCus",dao.findAll());
        return "/list";
    }

}
