package hue.elte.web.practice.ToDo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotHelloController {
    @RequestMapping("/hello")
    public String index() {
        return "hello"; 
    }
}