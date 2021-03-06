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

/**
 * Created by aigens on 25/1/2016.
 */
public class HangSengCrawler extends BenefitCrawler {
    public HangSengCrawler(String language) {
        super(language);
    }

    @Override
    public void craw() throws IOException, ParseException {
        for (RawData rawData : this.getRawDatas()) {
            Document doc = null;

            try{
                doc = Jsoup.parse(rawData.content);



                Elements merchants = doc.select("#offer_content > li");
                List<Benefit> benefits = new ArrayList<Benefit>();
                for (Element merchant : merchants) {
                    String merchantHtml = merchant.html();
                    Benefit benefit = new Benefit();
                    benefit.setLanguage(this.language);
                    benefit.setBank("Hang Seng Bank");
                    String imageUrl = "";


                    if (this.language.equals("en")) {
                        benefit.addCard("Hang Seng Credit Card");
                        benefit.addCard("Hang Seng Affinity Card");
                        imageUrl =  "http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/eng/";
                    } else if (this.language.equals("zh_TW")) {
                        benefit.addCard("恒生信用卡");
                        benefit.addCard("恒生聯營卡");
                        imageUrl =  "http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/";
                    } else {
                        benefit.addCard("恒生信用卡");
                        benefit.addCard("恒生联营卡");
                        imageUrl =  "http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/schi/";
                    }
                    benefit.setImageUrl(imageUrl + merchant.select(".logo img").attr("src"));

                    try {
                        benefit.setFrom(new SimpleDateFormat("yyyy-MM-dd").parse("2016-01-01"));
                        benefit.setTo(new SimpleDateFormat("yyyy-MM-dd").parse("2016-12-31"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String title = merchant.select(".tl").html();
                    String phone = merchant.select(".ct").html();
                    phone = regexCaptureFirst("(\\d{4} \\d{4})", phone).replace(" ", "");

                    extractBenefits(benefit, merchant);
                    benefit.setMerchantPhone(phone);

                    String tncLink = rawData.url;
                    benefit.setMerchant(title);
                    benefit.settAndCLink(tncLink);
                    benefit.setCuisineType(rawData.cuisineType);
                    benefits.add(benefit);

                }
                this.benefits.addAll(benefits);
            }catch (Exception ex){


            }


        }

    }

    private void extractBenefits(Benefit benefit, Element merchant) {
        String benefitDescription = merchant.select(".detail ul li").html();
        String[] extractedBenefit = Jsoup.parse(StringUtils.substringBefore(benefitDescription, "<br")).text().split(" ");
        for (String extractBenefit : extractedBenefit) {
            benefit.addBenefitDescription(extractBenefit);

        }
    }
}
