package codegym.vn.exercise1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsdToVndController {
    @GetMapping("/usdtovnd")
    public String show() {
        return "/ex1/show";
    }
    @PostMapping("/result")
    public String save(@RequestParam("num") int num, @RequestParam("currency") String currency, Model model) {
        switch (currency) {
            case "usdtovnd":
                int result = num * 25410;
                model.addAttribute("result",result);
                break;
            case "vndtousd":
                int result1 = num / 25410;
                model.addAttribute("result",result1);
                break;
        }
        return "/ex1/show";
    }
}
