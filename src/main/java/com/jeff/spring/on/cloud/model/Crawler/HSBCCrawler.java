package com.jeff.spring.on.cloud.model.Crawler;

import com.jeff.spring.on.cloud.model.Benefit;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by aigens on 22/1/2016.
 */
public class HSBCCrawler extends BenefitCrawler {
    public HSBCCrawler(String language) {
        super(language);
    }

    @Override
    public void craw() throws IOException, ParseException {
        for (String url : urls) {
            try {
                Thread.sleep(10* 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Document doc = Jsoup.connect(url).get();
            Elements merchants = doc.select(".yroContent > .yro-promo-block");
            List<Benefit> benefits = new ArrayList<Benefit>();
            for (Element merchant : merchants) {
                String merchantHtml = merchant.html();
                Benefit benefit = new Benefit();
                benefit.setLanguage(this.language);
                benefit.setBank("HSBC");
                if(this.language.equals("en")){
                    benefit.addCard("HSBC Premier credit card");
                    benefit.addCard("HSBC Advance credit card");
                    benefit.addCard("HSBC Platinum credit card");
                    benefit.addCard("HSBC Others credit card");

                }else if(this.language.equals("zh_TW")){
                    benefit.addCard("匯豐卓越理財信用卡");
                    benefit.addCard("匯豐運籌理財信用卡");
                    benefit.addCard("匯豐白金信用卡");
                    benefit.addCard("其他匯豐信用卡");

                }else{
                    benefit.addCard("汇丰卓越理财信用卡");
                    benefit.addCard("汇丰运筹理财信用卡");
                    benefit.addCard("汇丰白金信用卡");
                    benefit.addCard("其他汇丰信用卡");

                }
                try {
                    benefit.setFrom(new SimpleDateFormat("yyyy-MM-dd").parse("2016-01-01"));
                    benefit.setTo(new SimpleDateFormat("yyyy-MM-dd").parse("2016-12-31"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String title = merchant.select(".title").html();
                String phoneAddressHtml  = merchant.select(" div.col-md-9 > ul > li:nth-child(1)").html();
                String phone = "";
                String address = "";

                phone = regexCaptureFirst("([\\d ]*)",phoneAddressHtml).replace(" ", "");

                address = regexCaptureFirst(Pattern.compile("<br>(.*)<br>",Pattern.MULTILINE),phoneAddressHtml).trim();

                String benefitDescription = merchant.select("div.col-md-9 p").html();
                if(url.contains("Birthday")){

                }else{
                    benefitDescription = StringUtils.substringBefore(benefitDescription,"<br");

                }
                benefit.setMerchantPhone(phone);
                if(address.length()>0){
                    benefit.addStoreLocation(address);

                }
                String tncLink   = "https://www.redhotoffers.hsbc.com.hk/"+merchant.select(" div.col-md-9 >ul >li> a").attr("href");
                benefit.setMerchant(title);
                benefit.settAndCLink(tncLink);
                benefit.addBenefitDescription(benefitDescription);
                benefits.add(benefit);
            }
            this.benefits.addAll(benefits);
        }
    }
}
