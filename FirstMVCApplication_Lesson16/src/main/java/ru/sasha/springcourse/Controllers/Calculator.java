package ru.sasha.springcourse.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculate")
public class Calculator {

    @GetMapping("/calc")
    public String multiplication(@RequestParam(value = "a") int a,
                                 @RequestParam(value = "b") int b,
                                 @RequestParam(value = "action") String action,
                                 Model model) {
        double result;


        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = a / (double)b;
                break;
            default:
                result = 0.0;
                break;
        }

        model.addAttribute("result", result);

//        model.addAttribute("a", a);
//        model.addAttribute("b", b);
//        model.addAttribute("action", action);
//        if (action == "multiplication") {
//            model.addAttribute("method","multiplication");
//            result = a * b;
//            System.out.println(result);
//        } else if(action == "addition") {
//            result = a + b;
//            model.addAttribute("result", result);
//        } else if(action == "subtraction") {
//            result = a - b;
//            model.addAttribute("result", result);
//        } else if (action == "division"){
//            result = a / (double)b;
//            model.addAttribute("result", result);
//        }
//        model.addAttribute("result", result);

        return ("calculator/result");
    }


}
