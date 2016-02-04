package com.jeff.spring.on.cloud.model;

import com.jeff.spring.on.cloud.model.Crawler.*;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * Created by aigens on 19/1/2016.
 */
public class CardBenefitsRepository {
    private static CardBenefitsRepository ourInstance = new CardBenefitsRepository();

    public static CardBenefitsRepository getInstance() {
        return ourInstance;
    }

    private CardBenefitsRepository() {
    }
    GuessCuisineOperation hsbcGuessCuisineOperation = new  GuessCuisineOperation() {
        @Override
        public String guessCuisineType(String url) {
            if(url.contains("Chinese")){
                return "chinese";
            }else if(url.contains("Japanese")){
                return "asian,japanese";
            }else if(url.contains("Western")){
                return "western";
            }else if(url.contains("Hotel")){
                return "hotel";
            }else if(url.contains("Birthday")) {
                return "hotel";
            }
            else
            {
                return "others";
            }
        }
    };
    public List<Benefit> crawHSBC() throws IOException, ParseException {
        BenefitCrawler crawlerTW = new HSBCCrawler("zh_TW");
        UrlLoadData urlLoadData = new UrlLoadData();

        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?spendingCat=dining&subCat=Hotel%20Dining&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?spendingCat=dining&subCat=Chinese%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?spendingCat=dining&subCat=Western%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?spendingCat=dining&subCat=Japanese%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?subCat=Birthday%20Treats&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?subCat=Birthday%20Treats&page=2&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?subCat=Birthday%20Treats&page=3&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");

        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?subCat=Online%20Offers&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?spendingCat=dining&subCat=Others&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.load(hsbcGuessCuisineOperation);
        crawlerTW.setRawDatas(urlLoadData.rawDatas);
        crawlerTW.craw();

        urlLoadData = new UrlLoadData();

        BenefitCrawler crawlerEN = new HSBCCrawler("en");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?spendingCat=dining&subCat=Hotel%20Dining&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?spendingCat=dining&subCat=Chinese%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?spendingCat=dining&subCat=Western%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?spendingCat=dining&subCat=Japanese%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?subCat=Birthday%20Treats&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?subCat=Birthday%20Treats&page=2&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?subCat=Birthday%20Treats&page=3&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");

        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?subCat=Online%20Offers&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?spendingCat=dining&subCat=Others&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");

        urlLoadData.load(hsbcGuessCuisineOperation);
        crawlerEN.setRawDatas(urlLoadData.rawDatas);
        crawlerEN.craw();

        urlLoadData = new UrlLoadData();


        BenefitCrawler crawlerCN = new HSBCCrawler("zh_CN");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?spendingCat=dining&subCat=Hotel%20Dining&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?spendingCat=dining&subCat=Chinese%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?spendingCat=dining&subCat=Western%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?spendingCat=dining&subCat=Japanese%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?subCat=Birthday%20Treats&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?subCat=Birthday%20Treats&page=2&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?subCat=Birthday%20Treats&page=3&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");

        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?subCat=Online%20Offers&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?spendingCat=dining&subCat=Others&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        urlLoadData.load(hsbcGuessCuisineOperation);
        crawlerCN.setRawDatas(urlLoadData.rawDatas);
        crawlerCN.craw();
        List<Benefit> benefits = new ArrayList<Benefit>();

        assignBenefitId(crawlerEN.getBenefits(), "HSBC-");
        assignBenefitId(crawlerTW.getBenefits(), "HSBC-");
        assignBenefitId(crawlerCN.getBenefits(), "HSBC-");

        benefits.addAll(crawlerEN.getBenefits());
        benefits.addAll(crawlerTW.getBenefits());

        benefits.addAll(crawlerCN.getBenefits());
        return benefits;
    }

    GuessCuisineOperation hangsengGuessCuisineOperation = new  GuessCuisineOperation() {
        @Override
        public String guessCuisineType(String url) {
            if(url.contains("chinese_food_0")){
                return "chinese";
            }else if(url.contains("asian_food_0")){
                return "asian";
            }else if(url.contains("western_food_0")){
                return "western";
            }else{
                return "others";
            }
        }
    };

    public List<Benefit> crawHangSeng() throws IOException, ParseException {



        UrlLoadData urlLoadData = new UrlLoadData();

        for (int i = 0; i < 10; i++) {
            urlLoadData.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/eng/chinese_food_0" + i + ".html");
            urlLoadData.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/eng/asian_food_0" + i + ".html");
            urlLoadData.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/eng/western_food_0" + i + ".html");
            urlLoadData.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/eng/other_food_0" + i + ".html");
        }
        urlLoadData.load(hangsengGuessCuisineOperation);

        HangSengCrawler hangSengCrawlerEN = new HangSengCrawler("en");
        hangSengCrawlerEN.setRawDatas(urlLoadData.rawDatas);

         urlLoadData = new UrlLoadData();

        for (int i = 0; i < 10; i++) {
            urlLoadData.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/chinese_food_0" + i + ".html");
            urlLoadData.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/asian_food_0" + i + ".html");
            urlLoadData.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/western_food_0" + i + ".html");
            urlLoadData.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/other_food_0" + i + ".html");
        }
        urlLoadData.load(hangsengGuessCuisineOperation);

        HangSengCrawler hangSengCrawlerTW = new HangSengCrawler("zh_TW");
        hangSengCrawlerTW.setRawDatas(urlLoadData.rawDatas);


        //schi,eng,chi



        urlLoadData = new UrlLoadData();

        for (int i = 0; i < 10; i++) {
            urlLoadData.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/schi/chinese_food_0" + i + ".html");
            urlLoadData.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/schi/asian_food_0" + i + ".html");
            urlLoadData.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/schi/western_food_0" + i + ".html");
            urlLoadData.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/schi/other_food_0" + i + ".html");
        }
        urlLoadData.load(hangsengGuessCuisineOperation);
        HangSengCrawler hangSengCrawlerCN = new HangSengCrawler("zh_CN");
        hangSengCrawlerCN.setRawDatas(urlLoadData.rawDatas);


        hangSengCrawlerCN.craw();
        hangSengCrawlerEN.craw();
        hangSengCrawlerTW.craw();
        List<Benefit> benefits = new ArrayList<Benefit>();
        assignBenefitId(hangSengCrawlerEN.getBenefits(), "HANGSENG-");
        assignBenefitId(hangSengCrawlerTW.getBenefits(), "HANGSENG-");
        assignBenefitId(hangSengCrawlerCN.getBenefits(), "HANGSENG-");
        benefits.addAll(hangSengCrawlerEN.getBenefits());
        benefits.addAll(hangSengCrawlerTW.getBenefits());
        benefits.addAll(hangSengCrawlerCN.getBenefits());


        return benefits;
    }
    GuessCuisineOperation ccbGuessCuisineOperation = new  GuessCuisineOperation() {
        @Override
        public String guessCuisineType(String url) {
            if(url.contains("diningchi")){
                return "chinese";
            }else if(url.contains("diningjap")){
                return "asian,japanese";
            }else if(url.contains("diningwes")){
                return "western";
            }else{
                return "others";
            }
        }
    };
    public List<Benefit> crawCCB() throws IOException, ParseException {

        BenefitCrawler benefitCrawlerCN = new CCBBenefitCrawler("zh_CN");
        UrlLoadData urlLoadData = new UrlLoadData();
        urlLoadData.addUrl("http://www.asia.ccb.com/hongkong_sc/personal/credit_cards/yearroundoffers/diningchi/index_content.html");
        urlLoadData.addUrl("http://www.asia.ccb.com/hongkong_sc/personal/credit_cards/yearroundoffers/diningwes/index_content.html");
        urlLoadData.addUrl("http://www.asia.ccb.com/hongkong_sc/personal/credit_cards/yearroundoffers/diningjap/index_content.html");
        urlLoadData.addUrl("http://www.asia.ccb.com/hongkong_sc/personal/credit_cards/yearroundoffers/diningothers/index_content.html");

        urlLoadData.load(ccbGuessCuisineOperation);
        benefitCrawlerCN.setRawDatas(urlLoadData.rawDatas);
        benefitCrawlerCN.craw();


        BenefitCrawler benefitCrawlerTW = new CCBBenefitCrawler("zh_TW");

        urlLoadData = new UrlLoadData();
        urlLoadData.addUrl("http://www.asia.ccb.com/hongkong_tc/personal/credit_cards/yearroundoffers/diningchi/index_content.html");
        urlLoadData.addUrl("http://www.asia.ccb.com/hongkong_tc/personal/credit_cards/yearroundoffers/diningwes/index_content.html");
        urlLoadData.addUrl("http://www.asia.ccb.com/hongkong_tc/personal/credit_cards/yearroundoffers/diningjap/index_content.html");
        urlLoadData.addUrl("http://www.asia.ccb.com/hongkong_tc/personal/credit_cards/yearroundoffers/diningothers/index_content.html");
        urlLoadData.load(ccbGuessCuisineOperation);
        benefitCrawlerTW.setRawDatas(urlLoadData.rawDatas);
        benefitCrawlerTW.craw();

        BenefitCrawler benefitCrawlerEN = new CCBBenefitCrawler("en");
        new UrlLoadData();
        urlLoadData.addUrl("http://www.asia.ccb.com/hongkong/personal/credit_cards/yearroundoffers/diningchi/index_content.html");
        urlLoadData.addUrl("http://www.asia.ccb.com/hongkong/personal/credit_cards/yearroundoffers/diningwes/index_content.html");
        urlLoadData.addUrl("http://www.asia.ccb.com/hongkong/personal/credit_cards/yearroundoffers/diningjap/index_content.html");
        urlLoadData.addUrl("http://www.asia.ccb.com/hongkong/personal/credit_cards/yearroundoffers/diningothers/index_content.html");
        urlLoadData.load(ccbGuessCuisineOperation);
        benefitCrawlerEN.setRawDatas(urlLoadData.rawDatas);
        benefitCrawlerEN.craw();
        List<Benefit> benefits = new ArrayList<Benefit>();

        assignBenefitId(benefitCrawlerEN.getBenefits(), "CCB-");
        assignBenefitId(benefitCrawlerTW.getBenefits(), "CCB-");
        assignBenefitId(benefitCrawlerCN.getBenefits(), "CCB-");
        benefits.addAll(benefitCrawlerEN.getBenefits());
        benefits.addAll(benefitCrawlerTW.getBenefits());

        benefits.addAll(benefitCrawlerCN.getBenefits());


        return benefits;
    }
    public void assignBenefitId(List<Benefit> benefits, String appendance,int i) {

        for (Benefit benefit : benefits) {
            benefit.setId(appendance + i);
            i++;
        }
    }
    public void assignBenefitId(List<Benefit> benefits, String appendance) {
        assignBenefitId(benefits,appendance,1);
    }

    public List<Benefit> crawCITY() throws IOException, ParseException {
        BenefitCrawler benefitCrawlerEN = new CityBankCrawler("en");
        BenefitCrawler benefitCrawlerTW = new CityBankCrawler("zh_TW");
        BenefitCrawler benefitCrawlerCN = new CityBankCrawler("zh_CN");
        UrlLoadData urlLoadData = new UrlLoadData();
        urlLoadData.addUrl("https://www.citibank.com.hk/english/credit-cards/js/itemArray.js");
        urlLoadData.load(new GuessCuisineOperation() {
            @Override
            public String guessCuisineType(String url) {
                //because city is guessed according to the data
                return null;
            }
        });
        benefitCrawlerEN.setRawDatas(urlLoadData.rawDatas);
        benefitCrawlerCN.setRawDatas(urlLoadData.rawDatas);

        benefitCrawlerTW.setRawDatas(urlLoadData.rawDatas);

        benefitCrawlerEN.craw();
        benefitCrawlerTW.craw();

        benefitCrawlerCN.craw();
        List<Benefit> benefits = new ArrayList<Benefit>();
        benefits.addAll(benefitCrawlerEN.getBenefits());
        benefits.addAll(benefitCrawlerTW.getBenefits());
        benefits.addAll(benefitCrawlerCN.getBenefits());

        return benefits;
    }

    public List<Benefit> crawAmericanExpress() throws IOException, ParseException {


        BenefitCrawler benefitCrawlerTW = new AmericanExpressCrawler("zh_TW");
        benefitCrawlerTW.addUrl("http://merchantgeo.force.com/selectsJSON?pageType=gvp&jsonType=gvpofferlist&campaignID=Cam-0000521&category=Dining&lang=zh-hk&sort=&offerSize=10000&pageNo=1&jsoncallback=crawler");
        benefitCrawlerTW.craw();


        BenefitCrawler benefitCrawlerEN = new AmericanExpressCrawler("en");
        benefitCrawlerEN.addUrl("http://merchantgeo.force.com/selectsJSON?pageType=gvp&jsonType=gvpofferlist&campaignID=Cam-0000521&category=Dining&sort=&offerSize=10000&pageNo=1&jsoncallback=crawler");
        benefitCrawlerEN.craw();

        List<Benefit> benefits = new ArrayList<Benefit>();
        benefits.addAll(benefitCrawlerTW.getBenefits());
        benefits.addAll(benefitCrawlerEN.getBenefits());
        return benefits;
    }
    public  List<String> dbsCardTypes(String language) throws IOException {
        List<String> cardTypes = new ArrayList<String>();
        if(language.equals("en")){
            cardTypes.add("DBS Black World MasterCard®");
            cardTypes.add("DBS Black American Express® Card");
            cardTypes.add("DBS Eminent Card");
            cardTypes.add("DBS Platinum Credit Card");
            cardTypes.add("COMPASS VISA & CV+");
            cardTypes.add("Other DBS Credit Cards");
            cardTypes.add("DBS Treasures ATM Card");

        }else if(language.equals("zh_TW")){
            cardTypes.add("DBS Black World MasterCard®");
            cardTypes.add("DBS Black American Express® Card");
            cardTypes.add("DBS Eminent Card");
            cardTypes.add("DBS 白金信用卡");
            cardTypes.add("COMPASS VISA 及 CV+");
            cardTypes.add("其他 DBS 信用卡");


        }else{
            throw  new RuntimeException();
        }
        return  cardTypes;
    }
    GuessCuisineOperation dbdGuessCuisineOperation = new  GuessCuisineOperation() {
        @Override
        public String guessCuisineType(String url) {
            if(url.contains("igh5lwre")||url.contains("igh5lrmd")){
                return "chinese";
            }else if(url.contains("igh5lw46")||url.contains("igh5lrp5")){
                return "asian";
            }else if(url.contains("igh5lw4d")||url.contains("igh5lrnb")){
                return "western";
            }else if(url.contains("igh5lwt8")||url.contains("igh5lrnp")) {
                return "asian,japanese";
            }
            else{
                return "others";
            }
        }
    };

    public List<Benefit> crawDBS() throws IOException, ParseException {
        //chi b1 = igh5lw3q,
        //b2 = igh5lwre mean 中式
        //b2 = igh5lw4d mean western
        //b2 = igh5lwt8 mean japanese
        //b2 = igh5lw46 mean 東南亞
        //b2 = igh5lwrr mean other

        //eng b1 = igh5lrm9
        //b2 = igh5lrmd mean 中式
        //b2 = igh5lrnb mean western
        //b2 = igh5lrnp mean japanese
        //b2 = igh5lrp5 mean 東南亞
        //b2 = igh5lsof mean other

        BenefitCrawler benefitCrawlerEN = new DBSCrawler("en");
        JsoupConnectionLoadData loadData = new JsoupConnectionLoadData();
        List<String> enCategorys = new ArrayList<String>();
        enCategorys.add("igh5lrmd");
        enCategorys.add("igh5lrnb");
        enCategorys.add("igh5lrnp");
        enCategorys.add("igh5lrp5");
        enCategorys.add("igh5lsof");

        for(String cardType:dbsCardTypes("en")){
            for(int start = 1;start  < 3;start++) {
                for(String b2:enCategorys){

                    loadData.addConnection(Jsoup.connect("http://www.dbs.com.hk/personal/credit-cards/offers-child-page.page")
                            .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                            .data("b1", "igh5lrm9")
                            .data("b2", b2)
                            .data("SearchOffers", "true")
                            .data("SearchProducts", "false")
                            .data("start", "" + 1)
                            .data("pageNum", "1")
                            .data("PromotionType", "iehek24j")
                            .data("moretext", "more")
                            .data("prodMap", cardType));
                }
            }
        }
        loadData.load(dbdGuessCuisineOperation);
        benefitCrawlerEN.setRawDatas(loadData.rawDatas);
        benefitCrawlerEN.craw();










        BenefitCrawler benefitCrawlerTW = new DBSCrawler("zh_TW");
         loadData = new JsoupConnectionLoadData();
        List<String> twCategorys = new ArrayList<String>();
        twCategorys.add("igh5lrmd");
        twCategorys.add("igh5lrnb");
        twCategorys.add("igh5lrnp");
        twCategorys.add("igh5lrp5");
        twCategorys.add("igh5lsof");

        for(String cardType:dbsCardTypes("zh_TW")){
            for(int start = 1;start  < 3;start++) {
                for(String b2:twCategorys){

                    loadData.addConnection(Jsoup.connect("http://www.dbs.com.hk/personal/credit-cards/offers-child-page.page")
                            .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                            .data("b1", "igh5lrm9")
                            .data("b2", b2)
                            .data("SearchOffers", "true")
                            .data("SearchProducts", "false")
                            .data("start", "" + 1)
                            .data("pageNum", "1")
                            .data("PromotionType", "iehek24j")
                            .data("moretext", "more")
                            .data("prodMap", cardType));
                }
            }
        }
        loadData.load(dbdGuessCuisineOperation);
        benefitCrawlerTW.setRawDatas(loadData.rawDatas);
        benefitCrawlerTW.craw();


        List<Benefit> benefits = new ArrayList<Benefit>();
        benefits.addAll(benefitCrawlerEN.getBenefits());
        benefits.addAll(benefitCrawlerTW.getBenefits());
        Collections.sort(benefitCrawlerEN.getBenefits(), BenefitPhoneComparator);
        Collections.sort(benefitCrawlerTW.getBenefits(), BenefitPhoneComparator);
        assignBenefitId(benefitCrawlerEN.getBenefits(), "DBS-");
        assignBenefitId(benefitCrawlerTW.getBenefits(), "DBS-");
        //you need to manually match the empty phone dbs language
        return benefits;
    }
    public List<Benefit> crawSC() throws IOException, ParseException {
        List<Benefit> benefits = new ArrayList<Benefit>();
       benefits.addAll(crawSCWithoutEmpty());

        benefits.addAll(crawSCWithEmpty(59));
        return benefits;
    }
    GuessCuisineOperation scGuessCuisineOperation = new  GuessCuisineOperation() {
        @Override
        public String guessCuisineType(String url) {
            if(url.contains("hotel")){
                return "hotel";
            }else if(url.contains("asian")){
                return "asian";
            }else if(url.contains("western")){
                return "western";
            }else{
                return "others";
            }
        }
    };
    public List<Benefit> crawSCWithEmpty(int starterId) throws IOException, ParseException {


        BenefitCrawler benefitCrawlerTW = new StandCatardCrawler("zh_TW");
        UrlLoadData urlLoadData = new UrlLoadData();
        urlLoadData.addUrl("https://www.sc.com/hk/zh/promotion/credit-cards/year-round-offers-2016/dining-hotel.html");
        urlLoadData.addUrl("https://www.sc.com/hk/zh/promotion/credit-cards/year-round-offers-2016/dining-asian.html");
        urlLoadData.addUrl("https://www.sc.com/hk/zh/promotion/credit-cards/year-round-offers-2016/dining-western.html");
        urlLoadData.addUrl("https://www.sc.com/hk/zh/promotion/credit-cards/year-round-offers-2016/dining-others.html");

        urlLoadData.load(scGuessCuisineOperation);
        benefitCrawlerTW.setRawDatas(urlLoadData.rawDatas);
        benefitCrawlerTW.craw();


        urlLoadData = new UrlLoadData();
        urlLoadData.addUrl("https://www.sc.com/hk/promotion/credit-cards/year-round-offers-2016/dining-hotel.html");
        urlLoadData.addUrl("https://www.sc.com/hk/promotion/credit-cards/year-round-offers-2016/dining-asian.html");
        urlLoadData.addUrl("https://www.sc.com/hk/promotion/credit-cards/year-round-offers-2016/dining-western.html");
        urlLoadData.addUrl("https://www.sc.com/hk/promotion/credit-cards/year-round-offers-2016/dining-others.html");
        urlLoadData.load(scGuessCuisineOperation);

        BenefitCrawler benefitCrawlerEN = new StandCatardCrawler("en");
        benefitCrawlerEN.setRawDatas(urlLoadData.rawDatas);
        benefitCrawlerEN.craw();
        List<Benefit> benefits = new ArrayList<Benefit>();
        List<Benefit> enBenefits = benefitCrawlerEN.getBenefits();
        List<Benefit> twBenefits = benefitCrawlerTW.getBenefits();
        Iterator<Benefit> i = enBenefits.iterator();
        while (i.hasNext()) {
            Benefit s = i.next(); // must be called before you can call i.remove()
            // Do something
            if (s.getMerchantPhone() != null) {
                i.remove();
            }
        }
        Iterator<Benefit> t = twBenefits.iterator();
        while (t.hasNext()) {
            Benefit s = t.next(); // must be called before you can call i.remove()
            // Do something
            if (s.getMerchantPhone() != null) {
                t.remove();
            }
        }
        Collections.sort(enBenefits, BenefitPhoneComparator);
        Collections.sort(twBenefits, BenefitPhoneComparator);
        assignBenefitId(benefitCrawlerEN.getBenefits(), "SC-",starterId);
        assignBenefitId(benefitCrawlerTW.getBenefits(), "SC-",starterId);

        benefits.addAll(enBenefits);
        benefits.addAll(twBenefits);
        //you need to manually match the empty phone dbs language
        return benefits;
    }

    public List<Benefit> crawSCWithoutEmpty() throws IOException, ParseException {


        BenefitCrawler benefitCrawlerTW = new StandCatardCrawler("zh_TW");
        UrlLoadData urlLoadData = new UrlLoadData();
        urlLoadData.addUrl("https://www.sc.com/hk/zh/promotion/credit-cards/year-round-offers-2016/dining-hotel.html");
        urlLoadData.addUrl("https://www.sc.com/hk/zh/promotion/credit-cards/year-round-offers-2016/dining-asian.html");
        urlLoadData.addUrl("https://www.sc.com/hk/zh/promotion/credit-cards/year-round-offers-2016/dining-western.html");
        urlLoadData.addUrl("https://www.sc.com/hk/zh/promotion/credit-cards/year-round-offers-2016/dining-others.html");

        urlLoadData.load(scGuessCuisineOperation);
        benefitCrawlerTW.setRawDatas(urlLoadData.rawDatas);
        benefitCrawlerTW.craw();


        urlLoadData = new UrlLoadData();
        urlLoadData.addUrl("https://www.sc.com/hk/promotion/credit-cards/year-round-offers-2016/dining-hotel.html");
        urlLoadData.addUrl("https://www.sc.com/hk/promotion/credit-cards/year-round-offers-2016/dining-asian.html");
        urlLoadData.addUrl("https://www.sc.com/hk/promotion/credit-cards/year-round-offers-2016/dining-western.html");
        urlLoadData.addUrl("https://www.sc.com/hk/promotion/credit-cards/year-round-offers-2016/dining-others.html");
        urlLoadData.load(scGuessCuisineOperation);

        BenefitCrawler benefitCrawlerEN = new StandCatardCrawler("en");
        benefitCrawlerEN.setRawDatas(urlLoadData.rawDatas);
        benefitCrawlerEN.craw();
        List<Benefit> benefits = new ArrayList<Benefit>();
        List<Benefit> enBenefits = benefitCrawlerEN.getBenefits();
        List<Benefit> twBenefits = benefitCrawlerTW.getBenefits();
        Iterator<Benefit> i = enBenefits.iterator();
        while (i.hasNext()) {
            Benefit s = i.next(); // must be called before you can call i.remove()
            // Do something
            if (s.getMerchantPhone() == null) {
                i.remove();
            }
        }
        Iterator<Benefit> t = twBenefits.iterator();
        while (t.hasNext()) {
            Benefit s = t.next(); // must be called before you can call i.remove()
            // Do something
            if (s.getMerchantPhone() == null) {
                t.remove();
            }
        }
        Collections.sort(enBenefits, BenefitPhoneComparator);
        Collections.sort(twBenefits, BenefitPhoneComparator);
        assignBenefitId(benefitCrawlerEN.getBenefits(), "SC-");
        assignBenefitId(benefitCrawlerTW.getBenefits(), "SC-");
        benefits.addAll(enBenefits);
        benefits.addAll(twBenefits);
        //you need to manually match the empty phone dbs language
        return benefits;
    }

    public static Comparator<Benefit> BenefitPhoneComparator
            = new Comparator<Benefit>() {

        public int compare(Benefit benefit1, Benefit benefit2) {

            if (benefit1.getMerchantPhone() == null) {
                benefit1.setMerchantPhone("");
            }
            if (benefit2.getMerchantPhone() == null) {
                benefit2.setMerchantPhone("");
            }

            //ascending order
            return benefit1.getMerchantPhone().compareTo(benefit2.getMerchantPhone());

            //descending order
            //return fruitName2.compareTo(fruitName1);
        }

    };
}
