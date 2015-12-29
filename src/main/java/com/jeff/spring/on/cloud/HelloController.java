package com.jeff.spring.on.cloud;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!Jeff Testing-double";
    }
    @RequestMapping("/yolo")
    public String yolo(ModelMap modelMap) {
        modelMap.addAttribute("name","yolo");

        return "yolo";
    }
    @RequestMapping("/hello/{name}")
    public @ResponseBody String hello(@PathVariable("name") String name){
        return "Hello" + name;
    }
}
