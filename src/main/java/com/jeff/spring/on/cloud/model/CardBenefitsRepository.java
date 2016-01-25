package com.jeff.spring.on.cloud.model;

import com.jeff.spring.on.cloud.model.Crawler.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
    public List<Benefit> crawHSBC() throws IOException,ParseException{
        BenefitCrawler crawlerTW = new HSBCCrawler("zh_TW");
        crawlerTW.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?spendingCat=dining&subCat=Hotel%20Dining&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerTW.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?spendingCat=dining&subCat=Chinese%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerTW.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?spendingCat=dining&subCat=Western%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerTW.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?spendingCat=dining&subCat=Japanese%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerTW.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?subCat=Birthday%20Treats&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerTW.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?subCat=Birthday%20Treats&page=2&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerTW.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?subCat=Birthday%20Treats&page=3&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");

        crawlerTW.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?subCat=Online%20Offers&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerTW.addUrl("https://www.redhotoffers.hsbc.com.hk/tc/yro/?spendingCat=dining&subCat=Others&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");

        crawlerTW.craw();


        BenefitCrawler crawlerEN = new HSBCCrawler("en");
        crawlerEN.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?spendingCat=dining&subCat=Hotel%20Dining&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerEN.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?spendingCat=dining&subCat=Chinese%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerEN.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?spendingCat=dining&subCat=Western%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerEN.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?spendingCat=dining&subCat=Japanese%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerEN.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?subCat=Birthday%20Treats&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerEN.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?subCat=Birthday%20Treats&page=2&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerEN.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?subCat=Birthday%20Treats&page=3&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");

        crawlerEN.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?subCat=Online%20Offers&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerEN.addUrl("https://www.redhotoffers.hsbc.com.hk/en/yro/?spendingCat=dining&subCat=Others&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerEN.craw();

        BenefitCrawler crawlerCN = new HSBCCrawler("zh_CN");
        crawlerCN.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?spendingCat=dining&subCat=Hotel%20Dining&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerCN.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?spendingCat=dining&subCat=Chinese%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerCN.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?spendingCat=dining&subCat=Western%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerCN.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?spendingCat=dining&subCat=Japanese%20Cuisine&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerCN.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?subCat=Birthday%20Treats&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerCN.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?subCat=Birthday%20Treats&page=2&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerCN.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?subCat=Birthday%20Treats&page=3&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");

        crawlerCN.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?subCat=Online%20Offers&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerCN.addUrl("https://www.redhotoffers.hsbc.com.hk/sc/yro/?spendingCat=dining&subCat=Others&page=1&fbc=AMH_RBWM_OFF_MINI_M_YRO_001");
        crawlerCN.craw();
        List<Benefit> benefits = new ArrayList<Benefit>();
        benefits.addAll(crawlerTW.getBenefits());
        benefits.addAll(crawlerEN.getBenefits());
        benefits.addAll(crawlerCN.getBenefits());
        return benefits;
    }
    public List<Benefit> crawHangSeng() throws IOException,ParseException{
        HangSengCrawler hangSengCrawlerTW = new HangSengCrawler("zh_TW");
        for(int i = 0;i < 10;i++){
//            hangSengCrawler.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/hotel_dining_0"+i+".html");
            hangSengCrawlerTW.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/chinese_food_0"+i+".html");
            hangSengCrawlerTW.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/asian_food_0"+i+".html");
            hangSengCrawlerTW.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/western_food_0"+i+".html");
            hangSengCrawlerTW.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/other_food_0"+i+".html");

        }
        HangSengCrawler hangSengCrawlerEN = new HangSengCrawler("en");
        for(int i = 0;i < 10;i++){
//            hangSengCrawler.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/hotel_dining_0"+i+".html");
            hangSengCrawlerEN.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/chinese_food_0"+i+".html");
            hangSengCrawlerEN.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/asian_food_0" + i + ".html");
            hangSengCrawlerEN.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/western_food_0"+i+".html");
            hangSengCrawlerEN.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/other_food_0"+i+".html");

        }
        HangSengCrawler hangSengCrawlerCN = new HangSengCrawler("zh_CN");
        for(int i = 0;i < 10;i++){
//            hangSengCrawler.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/hotel_dining_0"+i+".html");
            hangSengCrawlerCN.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/chinese_food_0"+i+".html");
            hangSengCrawlerCN.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/asian_food_0"+i+".html");
            hangSengCrawlerCN.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/western_food_0"+i+".html");
            hangSengCrawlerCN.addUrl("http://www.hangseng.com/cms/emkt/pmo/common/com/yro_generic_card/chi/other_food_0"+i+".html");

        }
        hangSengCrawlerCN.craw();
        hangSengCrawlerEN.craw();
        hangSengCrawlerTW.craw();
        List<Benefit> benefits = new ArrayList<Benefit>();
        benefits.addAll(hangSengCrawlerCN.getBenefits());
        benefits.addAll(hangSengCrawlerTW.getBenefits());
        benefits.addAll(hangSengCrawlerEN.getBenefits());
        return benefits;
    }
    public List<Benefit> crawCCB() throws IOException, ParseException {

        BenefitCrawler benefitCrawlerCN = new CCBBenefitCrawler("zh_CN");
        benefitCrawlerCN.addUrl("http://www.asia.ccb.com/hongkong_sc/personal/credit_cards/yearroundoffers/diningchi/index_content.html");
        benefitCrawlerCN.addUrl("http://www.asia.ccb.com/hongkong_sc/personal/credit_cards/yearroundoffers/diningwes/index_content.html");
        benefitCrawlerCN.addUrl("http://www.asia.ccb.com/hongkong_sc/personal/credit_cards/yearroundoffers/diningjap/index_content.html");
        benefitCrawlerCN.addUrl("http://www.asia.ccb.com/hongkong_sc/personal/credit_cards/yearroundoffers/diningothers/index_content.html");
        benefitCrawlerCN.craw();


        BenefitCrawler benefitCrawlerTW = new CCBBenefitCrawler("zh_TW");
        benefitCrawlerTW.addUrl("http://www.asia.ccb.com/hongkong_tc/personal/credit_cards/yearroundoffers/diningchi/index_content.html");
        benefitCrawlerTW.addUrl("http://www.asia.ccb.com/hongkong_tc/personal/credit_cards/yearroundoffers/diningwes/index_content.html");
        benefitCrawlerTW.addUrl("http://www.asia.ccb.com/hongkong_tc/personal/credit_cards/yearroundoffers/diningjap/index_content.html");
        benefitCrawlerTW.addUrl("http://www.asia.ccb.com/hongkong_tc/personal/credit_cards/yearroundoffers/diningothers/index_content.html");
        benefitCrawlerTW.craw();

        BenefitCrawler benefitCrawlerEN = new CCBBenefitCrawler("en");
        benefitCrawlerEN.addUrl("http://www.asia.ccb.com/hongkong/personal/credit_cards/yearroundoffers/diningchi/index_content.html");
        benefitCrawlerEN.addUrl("http://www.asia.ccb.com/hongkong/personal/credit_cards/yearroundoffers/diningwes/index_content.html");
        benefitCrawlerEN.addUrl("http://www.asia.ccb.com/hongkong/personal/credit_cards/yearroundoffers/diningjap/index_content.html");
        benefitCrawlerEN.addUrl("http://www.asia.ccb.com/hongkong/personal/credit_cards/yearroundoffers/diningothers/index_content.html");
        benefitCrawlerEN.craw();
        List<Benefit> benefits = new ArrayList<Benefit>();
        benefits.addAll(benefitCrawlerEN.getBenefits());
        benefits.addAll(benefitCrawlerTW.getBenefits());
        benefits.addAll(benefitCrawlerCN.getBenefits());
        return benefits;
    }
    public List<Benefit> crawCITY() throws IOException, ParseException {

        BenefitCrawler benefitCrawlerTW = new CityBankCrawler("zh_TW");
        BenefitCrawler benefitCrawlerEN = new CityBankCrawler("en");
        BenefitCrawler benefitCrawlerCN = new CityBankCrawler("zh_CN");

        benefitCrawlerTW.addUrl("https://www.citibank.com.hk/english/credit-cards/js/itemArray.js");
        benefitCrawlerEN.addUrl("https://www.citibank.com.hk/english/credit-cards/js/itemArray.js");
        benefitCrawlerCN.addUrl("https://www.citibank.com.hk/english/credit-cards/js/itemArray.js");
        benefitCrawlerTW.craw();
        benefitCrawlerEN.craw();
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
    public List<Benefit> crawDBS() throws IOException, ParseException {
        BenefitCrawler benefitCrawlerEN = new DBSCrawler("en");

        benefitCrawlerEN.craw();

        BenefitCrawler benefitCrawlerTW = new DBSCrawler("zh_TW");

        benefitCrawlerTW.craw();
        List<Benefit> benefits = new ArrayList<Benefit>();
        benefits.addAll(benefitCrawlerEN.getBenefits());
        benefits.addAll(benefitCrawlerTW.getBenefits());
        return benefits;
    }
        public List<Benefit> crawSC() throws IOException, ParseException {


        BenefitCrawler benefitCrawlerTW = new StandCatardCrawler("zh_TW");
        benefitCrawlerTW.addUrl("https://www.sc.com/hk/zh/promotion/credit-cards/year-round-offers-2016/dining-hotel.html");
        benefitCrawlerTW.addUrl("https://www.sc.com/hk/zh/promotion/credit-cards/year-round-offers-2016/dining-asian.html");
        benefitCrawlerTW.addUrl("https://www.sc.com/hk/zh/promotion/credit-cards/year-round-offers-2016/dining-western.html");
        benefitCrawlerTW.addUrl("https://www.sc.com/hk/zh/promotion/credit-cards/year-round-offers-2016/dining-others.html");
        benefitCrawlerTW.craw();

        BenefitCrawler benefitCrawlerEN = new StandCatardCrawler("en");
        benefitCrawlerEN.addUrl("https://www.sc.com/hk/promotion/credit-cards/year-round-offers-2016/dining-hotel.html");
        benefitCrawlerEN.addUrl("https://www.sc.com/hk/promotion/credit-cards/year-round-offers-2016/dining-asian.html");
        benefitCrawlerEN.addUrl("https://www.sc.com/hk/promotion/credit-cards/year-round-offers-2016/dining-western.html");
        benefitCrawlerEN.addUrl("https://www.sc.com/hk/promotion/credit-cards/year-round-offers-2016/dining-others.html");
        benefitCrawlerEN.craw();
        List<Benefit> benefits = new ArrayList<Benefit>();
        benefits.addAll(benefitCrawlerEN.getBenefits());
        benefits.addAll(benefitCrawlerTW.getBenefits());

        return benefits;
    }
}
