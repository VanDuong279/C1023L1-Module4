package codegym.vn.exercise1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DictionaryController {
    @GetMapping()
    public String show() {
        return "/ex1/showDic";
    }
}
