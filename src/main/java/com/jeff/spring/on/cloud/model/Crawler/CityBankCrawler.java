package com.jeff.spring.on.cloud.model.Crawler;

import com.google.gson.Gson;
import com.jeff.spring.on.cloud.model.Benefit;
import com.jeff.spring.on.cloud.model.Crawler.CityBank.Promotion;
import com.jeff.spring.on.cloud.model.Crawler.CityBank.StoreInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aigens on 20/1/2016.
 */
public class CityBankCrawler extends BenefitCrawler {
    public CityBankCrawler(String language) {
        super(language);
    }

    @Override
    public void craw() throws IOException {
        URL url = new URL("https://www.citibank.com.hk/english/credit-cards/js/itemArray.js");
        
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;
        String json = "";
        while ((inputLine = in.readLine()) != null)
            json += inputLine;
        in.close();
        json = json.replace("var itemArray = ", "");

        Gson gson = new Gson();

        List<Promotion> promotions = Arrays.asList(gson.fromJson(json, Promotion[].class));
        for(Promotion promotion:promotions){
            Benefit benefit = new Benefit();
            benefit.setLanguage(this.language);
            benefit.setBank("city");

            try {
                benefit.setFrom(new SimpleDateFormat("dd/MM/yyyy").parse(promotion.validFrom));
                benefit.setTo(new SimpleDateFormat("dd/MM/yyyy").parse(promotion.validTill));
                benefit.setMerchant(promotion.merchantName.en);
                benefit.settAndCLink("https://www.citibank.com.hk/english/credit-cards/promotions-year-round-privileges.htm?lid=HKENCBLCCLNTLYEARROUNDOFFERSCCLN");
                benefit.addBenefitDescription(promotion.offerDescriptionFull.en);
                benefit.addCard("1");
                if(promotion.outletInfo.en.size() > 0){
                    benefit.setMerchantPhone(promotion.outletInfo.en.get(0).outletTel);
                    for(StoreInfo storeInfo :promotion.outletInfo.en){
                        benefit.addStoreLocation(storeInfo.outletAddress);

                    }

                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.benefits.add(benefit);
        }
    }
}
