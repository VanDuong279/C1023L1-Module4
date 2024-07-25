package codegym.vn.exercise2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping("/show")
    public String showCacu() {
        return "/ex2/caculator";
    }

    @PostMapping("/savecacu")
    public String save(@RequestParam("num1") int num1, @RequestParam("num2") int num2, @RequestParam("caculation") String caculation, Model model) {
        switch (caculation) {
            case "+":
                int result = num1 + num2;
                model.addAttribute("result", result);
                break;
            case "-":
                int result1 = num1 - num2;
                model.addAttribute("result", result1);
                break;
            case "*":
                int result2 = num1 * num2;
                model.addAttribute("result", result2);
                break;
            case "/":
                if (num2 == 0) {
                    model.addAttribute("message", "Không được bé hơn hoặc bằng 0");
                } else {
                    int result3 = num1 / num2;
                    model.addAttribute("result", result3);
                }
                break;
        }
        return "/ex2/caculator";
    }
}
