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
import java.util.HashMap;

/**
 * Created by aigens on 18/1/2016.
 */
public class StandCatardCrawler extends BenefitCrawler {
    public StandCatardCrawler(String language) {
        super(language);
    }

    public void addCardToBenefit(Benefit benefit, Element merchant) {
        //e.g visa_zh_CN=>Visa
        HashMap<String, String> translations = new HashMap<String, String>();
        translations.put("visa_zh_TW", "渣打Visa信用卡");
        translations.put("master_zh_TW", "渣打萬事達卡");
        translations.put("unionpay_zh_TW", "渣打銀聯雙幣白金信用卡");
        translations.put("amex_zh_TW", "渣打WorldMiles卡 (前名為渣打American Express®卡)");
//        translations.put("visa_zh_CN", "渣打Visa信用卡");
//        translations.put("master_zh_CN","渣打萬事達卡");
//        translations.put("unionpay_zh_CN","渣打銀聯雙幣白金信用卡");
//        translations.put("amex_zh_CN","渣打WorldMiles卡 (前名為渣打American Express®卡)");
        translations.put("visa_en", "Standard Chartered Visa Credit Card");
        translations.put("master_en", "Standard Chartered MasterCard");
        translations.put("unionpay_en", "Standard Chartered UnionPay Dual Currency Platinum Credit Card");
        translations.put("amex_en", "Standard Chartered WorldMiles Card (formerly known as Standard Chartered American Express® Card)");

        for (Element html : merchant.select("td:nth-child(2) > div:nth-child(2)")) {
            if (html.html().contains("visa")) {
                benefit.addCard(translations.get("visa_" + this.language));
            }
            if (html.html().contains("master")) {
                benefit.addCard(translations.get("master_" + this.language));

            }
            if (html.html().contains("unionpay")) {
                benefit.addCard(translations.get("unionpay_" + this.language));

            }
            if (html.html().contains("amex")) {
                benefit.addCard(translations.get("amex_" + this.language));

            }

        }
    }

    @Override
    public void craw() throws IOException {
        for (RawData rawData : this.getRawDatas()) {
            Document doc =             Jsoup.parse(rawData.content);
            Elements merchants = doc.select("#table > tbody > tr");

            for (Element merchant : merchants) {
                Benefit benefit = new Benefit();
                benefit.setLanguage(this.language);
                benefit.setBank("Standard Chatard");

                addCardToBenefit(benefit, merchant);

                benefit.setMerchant(merchant.select("td:nth-child(2) > div:nth-child(1)").text());
                String phone = regexCaptureFirst(".?(\\d{8}).*", StringUtils.remove(merchant.select(".contact").text()," "));
                if(phone.length() > 0){
                    benefit.setMerchantPhone(phone);

                }

                for (Element html : merchant.select(".highlight")) {
                    if (!html.text().contains(".com") && !html.text().contains(".hk")) {
                        benefit.addBenefitDescription(html.text());
                    }
                }


                benefit.settAndCLink(rawData.url);

                try {
                    benefit.setFrom(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2016-01-01 00:00:00"));
                    benefit.setTo(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2016-12-31 23:59:59"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String storeLocation  =merchant.select(".address").text();
                if(storeLocation.length() > 0){
                    benefit.addStoreLocation(storeLocation);

                }
                String imageUrl = "https://www.sc.com"+ merchant.select(".elitelogo img").attr("src");
                benefit.setImageUrl(imageUrl);
                benefit.setCuisineType(rawData.cuisineType);
                this.benefits.add(benefit);
            }

        }
    }
}
