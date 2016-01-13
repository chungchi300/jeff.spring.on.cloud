package com.jeff.spring.on.cloud;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
    @RequestMapping("/craw")
    public String craw(ModelMap modelMap) throws IOException {

        String result = "";
        Document doc = Jsoup.connect("http://www.asia.ccb.com/hongkong_tc/personal/credit_cards/yearroundoffers/diningchi/index_content.html").get();
        Elements merchants = doc.select("#master > div.inner > table:nth-child(n+3) > tbody > tr:nth-child(odd)");

        for (Element merchant : merchants) {
            String item = "";
            item += "Language: " + "en" + "</br>";
            item += "Bank: " + "CCB" + "</br>";

            item += "Card:" +  merchant.select("td:nth-child(2) > table > tbody > tr > td > table").text() + "</br>";
            item += "Merchant:" +  merchant.select("td:nth-child(2) > table > tbody > tr > td > h3").text() + "</br>";
            item += "MerchantPhone:" +  merchant.select("td:nth-child(3) > table > tbody > tr > td > p.icoTel").text() + "</br>";
            item += "Benefit:" + merchant.select("td:nth-child(2) > table > tbody > tr > td > ul > li").text() + "</br>";
            item += "tAndCLink:" +"http://www.asia.ccb.com/hongkong_tc/personal/credit_cards/yearroundoffers/diningchi/index_content.html"+  merchant.select("a").attr("href") + "</br>";
            item += "Period:" +  merchant.select(".icoPromo").text() + "</br>";
            item += "StoreLocation:" +  merchant.select(".icoLocation").text() + "</br>";

            result += "<hr /> <br /><br />"+ item + "<br /><br />";
        }

        return result;
    }

    @RequestMapping("/hello/{name}")
    public @ResponseBody String hello(@PathVariable("name") String name){
        return "Hello" + name;
    }
}
