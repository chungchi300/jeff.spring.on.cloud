package com.jeff.spring.on.cloud.model;

import com.jeff.spring.on.cloud.model.Crawler.BenefitCrawler;
import com.jeff.spring.on.cloud.model.Crawler.CCBBenefitCrawler;
import com.jeff.spring.on.cloud.model.Crawler.CityBankCrawler;
import com.jeff.spring.on.cloud.model.Crawler.StandCatardCrawler;

import java.io.IOException;
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
    public List<Benefit> crawCCB() throws IOException {

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
    public List<Benefit> crawCITY() throws IOException {
        BenefitCrawler benefitCrawlerCN = new CityBankCrawler("zh_CN");
        BenefitCrawler benefitCrawlerTW = new CityBankCrawler("zh_TW");
        BenefitCrawler benefitCrawlerEN = new CityBankCrawler("zh_en");
        benefitCrawlerCN.craw();
        List<Benefit> benefits = new ArrayList<Benefit>();
        benefits.addAll(benefitCrawlerEN.getBenefits());
        benefits.addAll(benefitCrawlerTW.getBenefits());
        benefits.addAll(benefitCrawlerCN.getBenefits());
        return benefits;
    }
    public List<Benefit> crawSC() throws IOException {


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
