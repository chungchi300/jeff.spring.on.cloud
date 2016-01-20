package com.jeff.spring.on.cloud.controller;

import com.google.gson.Gson;
import com.jeff.spring.on.cloud.model.Benefit;
import com.jeff.spring.on.cloud.model.CSVFormatter;
import com.jeff.spring.on.cloud.model.CardBenefitsRepository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class HelloController {
    private final Gson gson;

    {
        gson = new Gson();
    }
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
    String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


    @RequestMapping("/testPOI")
    public void testPOI(   HttpServletResponse res) throws IOException {

        List<Benefit> benefits = CardBenefitsRepository.getInstance().crawCITY();

        ByteArrayOutputStream baos = CSVFormatter.getInstance().convertBenefits(benefits);
        res.setHeader("Content-Disposition", "attachment; filename=\"export.csv\"");
        res.setContentType("application/csv"); // application/octet-stream
        baos.writeTo(res.getOutputStream());
    }
}
