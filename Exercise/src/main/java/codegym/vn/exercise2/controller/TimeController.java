package codegym.vn.exercise2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/world-clock")
    public String time(Model model, @RequestParam(name = "city",required = false,defaultValue = "Asia/Ho_Chi_Minh") String city){
        // Lấy ra thời gian hiện tại
        Date date = new Date();
        // Lấy ra time zone hiện tại
        TimeZone timeZone = TimeZone.getDefault();
        // Lấy ra time zone của 1 thành phố cụ thể
        TimeZone zone = TimeZone.getTimeZone(city);
        // Tính thời gian hiện tại của một thành phố cụ thể
        long localeTime = date.getTime() + (timeZone.getRawOffset() - zone.getRawOffset());
        // Cài đặt lại thời gian cho biến date thành thời gian hiện tại của 1 thành phố cụ thể
        date.setTime(localeTime);
        model.addAttribute("ctiy",city);
        model.addAttribute("date",date);
        return "/ex2/index";
    }

}
