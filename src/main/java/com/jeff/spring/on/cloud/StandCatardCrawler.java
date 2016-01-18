package com.jeff.spring.on.cloud;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by aigens on 18/1/2016.
 */
public class StandCatardCrawler extends BenefitCrawler {
    public StandCatardCrawler(String language) {
        super(language);
    }
    public void addCardToBenefit(Benefit benefit,Element merchant){
        //e.g visa_zh_CN=>Visa
        HashMap<String,String> translations = new HashMap<String,String>();
        translations.put("visa_zh_TW", "渣打Visa信用卡");
        translations.put("master_zh_TW","渣打萬事達卡");
        translations.put("unionpay_zh_TW","渣打銀聯雙幣白金信用卡");
        translations.put("amex_zh_TW","渣打WorldMiles卡 (前名為渣打American Express®卡)");
//        translations.put("visa_zh_CN", "渣打Visa信用卡");
//        translations.put("master_zh_CN","渣打萬事達卡");
//        translations.put("unionpay_zh_CN","渣打銀聯雙幣白金信用卡");
//        translations.put("amex_zh_CN","渣打WorldMiles卡 (前名為渣打American Express®卡)");
        translations.put("visa_en", "Standard Chartered Visa Credit Card");
        translations.put("master_en","Standard Chartered MasterCard");
        translations.put("unionpay_en","Standard Chartered UnionPay Dual Currency Platinum Credit Card");
        translations.put("amex_en","Standard Chartered WorldMiles Card (formerly known as Standard Chartered American Express® Card)");

        for(Element html:merchant.select("td:nth-child(2) > div:nth-child(2)")){
           if(html.html().contains("visa")){
                benefit.addCard(translations.get("visa_"+this.language));
           }else if(html.html().contains("master")){
               benefit.addCard(translations.get("master_"+this.language));

           }else if(html.html().contains("unionpay")){
               benefit.addCard(translations.get("unionpay_"+this.language));

           }else if(html.html().contains("amex")){
               benefit.addCard(translations.get("amex_"+this.language));

           }

        }
    }
    @Override
    public void craw() throws IOException {
        for(String url:urls){

            Document doc = Jsoup.connect(url).get();
            Elements merchants = doc.select("#table > tbody > tr");

            for (Element merchant : merchants) {
                Benefit benefit = new Benefit();
                benefit.setLanguage(this.language);
                benefit.setBank("sc");

                addCardToBenefit(benefit,merchant);

                benefit.setMerchant(merchant.select("td:nth-child(2) > div:nth-child(1)").text());
                benefit.setMerchantPhone(merchant.select(".contact").text());

                for(Element html:merchant.select(".highlight")){
                    if(!html.text().contains(".com")&&!html.text().contains(".hk")){
                      benefit.addBenefitDescription(html.text());
                    }
                }


                benefit.settAndCLink(url);
                benefit.setPeriod("2016");

                benefit.addStoreLocation(merchant.select(".address").text());
                this.benefits.add(benefit);
            }

        }
    }
}
