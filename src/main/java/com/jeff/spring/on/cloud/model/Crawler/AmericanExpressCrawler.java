package com.jeff.spring.on.cloud.model.Crawler;

import com.jeff.spring.on.cloud.model.Benefit;
import com.jeff.spring.on.cloud.model.Crawler.AmericanExpress.*;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aigens on 21/1/2016.
 */
public class AmericanExpressCrawler extends BenefitCrawler {
    public AmericanExpressCrawler(String language) {
        super(language);
    }



    @Override
    public void craw() throws IOException, ParseException {
        for(String link:this.urls){
            String result = loadHtml(link);
            String json = jsonPToJson(result,"crawler");
            Result parsedResult = gson.fromJson(json, Result.class);
            for (Offer offer : parsedResult.Offer_Data.Offers_List) {
                Benefit benefit = crawBenefit(offer);
                benefits.add(benefit);
            }

        }
    }
    public static List<String> extractBenefitDescription(String str){
        List<String> strings = Arrays.asList(str.split("<br>"));
        List<String> processedStrings = new ArrayList<String>();
        for(String splitedString:strings){
            processedStrings.add(Jsoup.parse(splitedString).text().trim().replace("\n","").replace("\r",""));
        }
        return processedStrings;
    }
    private Benefit crawBenefit(Offer offer) throws ParseException, IOException {
        Benefit benefit = new Benefit();
        benefit.setLanguage(this.language);
        //benefit.addBenefitDescription(offer.Headline);
        benefit.setMerchant(offer.Name);
        benefit.setFrom(new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").parse(offer.Start_Date));
        benefit.setTo(new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").parse(offer.End_Date));
        if (this.language.equals("en")) {
            benefit.addCard("American Express Card");
            benefit.setBank("American Express");
            String offerDetailJson = jsonPToJson(this.loadHtml("http://merchantgeo.force.com/selectsJSON?jsonType=offerDetails&campaignID=Cam-0000521&lang=en-us&jsoncallback=crawler&offerID=" + offer.Offer_id), "crawler");
            OfferDetailResult offerDetailResult = gson.fromJson(offerDetailJson, OfferDetailResult.class);
            OfferDetail offerDetail = offerDetailResult.Offer_Details;
            for(String benefitDescription:extractBenefitDescription(offerDetail.Description)){
                benefit.addBenefitDescription(benefitDescription);

            }
            if(offerDetail.Locations.size() > 0) {
                benefit.setMerchantPhone(offerDetail.Locations.get(0).Location_Phone);
            }
            benefit.settAndCLink("http://offers.amexnetwork.com/gvp?campaignID=Cam-0000521&category=Dining&categoryLanding=false&issuerName=hk_prop#&offerId=" + offer.Offer_id);
            for(Location location:offerDetail.Locations){
                benefit.addStoreLocation(location.Address);
            }
        }else if(this.language.equals("zh_TW")){
            benefit.addCard("美國運通卡");
            benefit.setBank("American Express");
            String offerDetailJson = jsonPToJson(this.loadHtml("http://merchantgeo.force.com/selectsJSON?jsonType=offerDetails&campaignID=Cam-0000521&lang=zh-hk&jsoncallback=crawler&offerID=" + offer.Offer_id), "crawler");
            OfferDetailResult offerDetailResult = gson.fromJson(offerDetailJson, OfferDetailResult.class);
            OfferDetail offerDetail = offerDetailResult.Offer_Details;
            for(String benefitDescription:extractBenefitDescription(offerDetail.Description)){
                benefit.addBenefitDescription(benefitDescription);

            }
            if(offerDetail.Locations.size() > 0) {
                benefit.setMerchantPhone(offerDetail.Locations.get(0).Location_Phone);
            }
            benefit.settAndCLink("http://offers.amexnetwork.com/gvp?campaignID=Cam-0000521&category=Dining&categoryLanding=false&lang=zh-hk&issuerName=hk_prop#&offerId=" + offer.Offer_id);
            for(Location location:offerDetail.Locations){
                benefit.addStoreLocation(location.Address);
            }
        }else{
            throw  new RuntimeException();
        }
        return benefit;
    }
}
