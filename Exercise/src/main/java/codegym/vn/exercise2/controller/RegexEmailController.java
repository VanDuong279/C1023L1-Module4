package codegym.vn.exercise2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class RegexEmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;

    public RegexEmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping("/")
    public String home() {
        return "/ex2/home";
    }
    @PostMapping("/validate")
    public String user(@RequestParam("email") String email, Model model) {
        boolean isValid = validate(email);
        if (!isValid) {
            model.addAttribute("message","Email is invalid");
            return "/ex2/home";
        }
        model.addAttribute("email",email);
        return "/ex2/success";
    }
    private boolean validate(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
