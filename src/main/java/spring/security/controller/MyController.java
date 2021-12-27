package spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getInfoForAllEmps() {
        return "view_for_all_employees";
    }

    @GetMapping("/driver_info")
    public String getInfoForDriver(){
        return "view_for_driver";
    }

    @GetMapping("/electricity_info")
    public String getInfoForElectricity(){
        return "view_for_electricity";
    }
}
