package com.jeff.spring.on.cloud.model.Crawler;

import com.google.gson.Gson;
import com.jeff.spring.on.cloud.model.Benefit;
import com.jeff.spring.on.cloud.model.Crawler.CityBank.Promotion;
import com.jeff.spring.on.cloud.model.Crawler.CityBank.StoreInfo;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

            String json = this.getRawDatas().get(0).content;

            json = json.replace("var itemArray = ", "");

            Gson gson = new Gson();

            List<Promotion> promotions = Arrays.asList(gson.fromJson(json, Promotion[].class));
            for (Promotion promotion : promotions) {
                if (promotion.mainCategory.equals("dining")) {


                    Benefit benefit = new Benefit();
                    benefit.setLanguage(this.language);
                    benefit.setBank("Citibank");
                    benefit.setId("CB-"+promotion.id);
                    if(promotion.category.contains("western")){
                        benefit.setCuisineType("western");
                    }else if(promotion.category.contains("chinese")){
                        benefit.setCuisineType("chinese");
                    }else if(promotion.category.contains("japanese")){
                        benefit.setCuisineType("asian,japanese");
                    }else if(promotion.category.contains("hotel_dining")){
                        benefit.setCuisineType("hotel");
                    }else {
                        benefit.setCuisineType("others");
                    }
                    String imageHost = "https://www.citibank.com.hk";
                    try {
                        benefit.setFrom(new SimpleDateFormat("MM/dd/yyyy").parse(promotion.validFrom));
                        benefit.setTo(new SimpleDateFormat("MM/dd/yyyy").parse(promotion.validTill));
                        if(this.language.equals("en")){
                            benefit.settAndCLink("https://www.citibank.com.hk/english/credit-cards/promotions-year-round-privileges.htm?lid=HKENCBLCCLNTLYEARROUNDOFFERSCCLN");
                            benefit.setMerchant(promotion.merchantName.en);
                            for(String benefitDescription: extractBenefitDescription(promotion.offerDescriptionFull.en)){
                                benefit.addBenefitDescription(benefitDescription);
                            }

                            benefit.addCard("Citi® Ultima Card");
                            benefit.addCard("Citi Prestige® Card");
                            benefit.addCard("Citi® PremierMiles Card");
                            benefit.addCard("Citi® Rewards Card And Octopus");
                            benefit.addCard("Citi® Platinum Card");
                            benefit.setImageUrl(imageHost+ StringUtils.substringAfter(promotion.img.en,"../.."));
                            if (promotion.outletInfo.en.size() > 0) {
                                benefit.setMerchantPhone(promotion.outletInfo.en.get(0).outletTel);
                                for (StoreInfo storeInfo : promotion.outletInfo.en) {
                                    benefit.addStoreLocation(storeInfo.outletAddress);
                                }
                            }

                        }else if(this.language.equals("zh_TW")){
                            benefit.settAndCLink("https://www.citibank.com.hk/chinese/credit-cards/promotions-year-round-privileges.htm?lid=HKENCBLCCLNTLYEARROUNDOFFERSCCLN");
                            benefit.setMerchant(promotion.merchantName.tc);
                            for(String benefitDescription: extractBenefitDescription(promotion.offerDescriptionFull.tc)){
                                benefit.addBenefitDescription(benefitDescription);
                            }

                            benefit.addCard("Citi® Ultima Card");
                            benefit.addCard("Citi Prestige® 信用卡");
                            benefit.addCard("Citi® PremierMiles 信用卡");
                            benefit.addCard("Citi® Rewards 信用卡及八達通");
                            benefit.addCard("Citi® 白金卡");
                            benefit.setImageUrl(imageHost + StringUtils.substringAfter(promotion.img.tc, "../.."));
                            if (promotion.outletInfo.tc.size() > 0) {
                                benefit.setMerchantPhone(promotion.outletInfo.tc.get(0).outletTel);
                                for (StoreInfo storeInfo : promotion.outletInfo.tc) {
                                    benefit.addStoreLocation(storeInfo.outletAddress);
                                }
                            }

                        }else{
                            benefit.settAndCLink("https://www.citibank.com.hk/chinese/credit-cards/promotions-year-round-privileges.htm?lid=HKENCBLCCLNTLYEARROUNDOFFERSCCLN");
                            benefit.setMerchant(promotion.merchantName.sc);
                            for(String benefitDescription: extractBenefitDescription(promotion.offerDescriptionFull.sc)){
                                benefit.addBenefitDescription(benefitDescription);
                            }

                            benefit.addCard("Citi® Ultima Card");
                            benefit.addCard("Citi Prestige® 信用卡");
                            benefit.addCard("Citi® PremierMiles 信用卡");
                            benefit.addCard("Citi® Rewards 信用卡及八达通");
                            benefit.addCard("Citi® 白金卡");
                            benefit.setImageUrl(imageHost + StringUtils.substringAfter(promotion.img.sc, "../.."));
                            if (promotion.outletInfo.sc.size() > 0) {
                                benefit.setMerchantPhone(promotion.outletInfo.sc.get(0).outletTel);
                                for (StoreInfo storeInfo : promotion.outletInfo.sc) {
                                    benefit.addStoreLocation(storeInfo.outletAddress);
                                }
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    this.benefits.add(benefit);
                }
            }

    }
    public static List<String> extractBenefitDescription(String str){
        str = str.replace("\\n","");
        List<String> benefitDescriptions = Arrays.asList(str.split("<br />"));

        List<String> resultBenefitDescriptions = new ArrayList<String>();

        for(String benefitDescription:benefitDescriptions){
            benefitDescription = benefitDescription.trim();

            if(!benefitDescription.equals("")){
                if((benefitDescription.charAt(0)+"").equals("*")
                        |(benefitDescription.charAt(0)+"").equals("^")
                        |(benefitDescription.charAt(0)+"").equals("＃"))break;

                resultBenefitDescriptions.add(benefitDescription.replace("*", "")
                        .replace("\n", "")
                        .replace("^", "")
                        .replace("#", "")
                        .replace("＃","")
                        .replace("1.", "")
                                .replace("1.", "")
                                .replace("2.", "")
                                .replace("3.", "")
                                .replace("4.", "")
                                .replace("5.", "")
                                .replace("6.", "")
                                .replace("7.", "")
                                .replace("8.", "")
                                .replace("9.","").trim()

                );
            }
        }
        return  resultBenefitDescriptions;
    }
}
