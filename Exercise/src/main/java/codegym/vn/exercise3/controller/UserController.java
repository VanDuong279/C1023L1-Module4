package codegym.vn.exercise3.controller;

import codegym.vn.exercise3.dao.UserDAO;
import codegym.vn.exercise3.model.Login;
import codegym.vn.exercise3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("login",new Login());
      return "/ex3/home";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login,Model model){
        User user = UserDAO.checkLogin(login);
        if (user == null) {
            return "/ex3/error";
        }
        model.addAttribute("user",user);
        return "/ex3/user";
    }
 }
