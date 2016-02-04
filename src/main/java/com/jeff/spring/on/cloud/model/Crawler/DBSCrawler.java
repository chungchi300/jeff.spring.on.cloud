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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aigens on 22/1/2016.
 */
public class DBSCrawler extends BenefitCrawler {
    public DBSCrawler(String language) {
        super(language);
    }

    @Override
    public void craw() throws IOException, ParseException {
        List<Benefit> benefits = new ArrayList<Benefit>();
//        for(RawData cardType: dbsCardTypes()){
            String host = "http://www.dbs.com.hk";
//            for(int start = 1;start  < 3;start++){
//                String url = "";
//                Document doc  = null;
//                if(this.language.equals("en")){
//                    url = host + "/personal/credit-cards/offers-child-page.page";
//                     doc =
//                            .get();
//                }else if(this.language.equals("zh_TW")){
//                    url = host + "/personal-zh/credit-cards/offers-child-page.page";
//                    doc = Jsoup.connect(url)
//                            .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
//                            .data("b1", "igh5lw3q")
//                            .data("SearchOffers","true")
//                            .data("SearchProducts","false")
//                            .data("start",""+start)
//                            .data("pageNum","1")
//                            .data("PromotionType","iehek2fp")
//                            .data("moretext","more")
//                            .data("prodMap",cardType)
//                            .get();
//                }else{
//                    throw new RuntimeException();
//                }
                for(RawData rawData:this.getRawDatas()){
                    String html = rawData.content;
                    Elements merchants = Jsoup.parse(html).select("#latestOffers .span4");
                    String merchantsHtml = merchants.html();

                    for(Element merchant:merchants){
                        Benefit benefit = new Benefit();
                        benefit.setCuisineType(rawData.cuisineType);
                        benefit.setLanguage(this.language);
                        benefit.setBank("DBS");
                        String phone = merchant.select(".latestoffers-info a").attr("href").replace("tel:","").substring(4).replace("-", "").replace(" ", "");
                        if(phone.length() > 8){
                            phone = phone.substring(0,8);
                        }
                        String merchantName = merchant.select(".h3-mimic").html();
                        String tncLink = host + merchant.select(".launch").attr("href");
                        String imageUrl = host+merchant.select(".pull-left img").attr("src");
                        benefit.setImageUrl(imageUrl);
                        String offerHtmlDetail = "";
                        String storeLocation = "";
                        if(this.language.equals("en")){

                            offerHtmlDetail =  Jsoup.parse(this.loadHtml(tncLink)).select(".product-summary").text();
                            storeLocation = StringUtils.substringBefore(offerHtmlDetail, "Tel");
                            storeLocation = StringUtils.substringAfter(storeLocation,"Address").trim();
                        }else if(this.language.equals("zh_TW")){
                            offerHtmlDetail =  Jsoup.parse(this.loadHtml(tncLink)).select(".product-summary").text();
                            storeLocation = StringUtils.substringBefore(offerHtmlDetail, "Tel");
                            storeLocation = StringUtils.substringAfter(storeLocation,"地址").trim();
                        }else{
                            throw  new RuntimeException();
                        }
                        benefit.addStoreLocation(storeLocation);
                        benefit.setMerchantPhone(phone);
                        benefit.setMerchant(merchantName);
                        benefit.settAndCLink(tncLink);
                        extractBenefitDetail(benefit, tncLink);
                        rawData.cardType = StringUtils.substringAfter(rawData.url,"prodMap=");
                        rawData.cardType  = java.net.URLDecoder.decode( rawData.cardType, "UTF-8");
                        benefits.add(benefit);

                    }

                }

//            }
//
//            }
            this.benefits.addAll(mergeBenefitCardTypeByPhoneNo(benefits));
    }

    private List<Benefit> mergeBenefitCardTypeByPhoneNo(List<Benefit> benefits) {
        //phoneNo-Benefit map
        Map<String,Benefit> phoneNoBenefit = createPhoneNoBenefitMap(benefits);
        for(Map.Entry<String,Benefit> entry:phoneNoBenefit.entrySet()){
            for(Benefit benefit:benefits){
                String benefitCard = benefit.getCards().get(0);
                String entryCard = entry.getValue().getCards().get(0);
                if(benefit.getMerchantPhone().equals(entry.getValue().getMerchantPhone()) && (!benefitCard.equals(entryCard))){
                    entry.getValue().addCard(benefitCard);
                }
            }
        }
        List<Benefit> list = new ArrayList<>(phoneNoBenefit.values());
        return list;
    }

    private Map<String, Benefit> createPhoneNoBenefitMap(List<Benefit> benefits) {
        Map<String,Benefit> phoneNoBenefit = new HashMap<>();
        for(Benefit benefit:benefits){
            if(!phoneNoBenefit.containsKey(benefit.getMerchantPhone())){
                phoneNoBenefit.put(benefit.getMerchantPhone(),benefit);
            }
        }
        return phoneNoBenefit;
    }

    private void extractBenefitDetail(Benefit benefit, String tncLink) throws IOException {

        String benefitDetailHtml = loadHtml(tncLink);
        Document doc = Jsoup.parse(benefitDetailHtml);
        String benefitDescription = doc.select(".introtextproddetaildescription").html();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        benefit.addBenefitDescription(benefitDescription);
        try {
            benefit.setFrom(new SimpleDateFormat("yyyy-MM-dd").parse("2016-01-01"));
            benefit.setTo(new SimpleDateFormat("yyyy-MM-dd").parse("2016-12-31"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
