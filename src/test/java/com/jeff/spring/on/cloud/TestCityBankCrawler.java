package com.jeff.spring.on.cloud;

import com.jeff.spring.on.cloud.model.Benefit;
import com.jeff.spring.on.cloud.model.Crawler.BenefitCrawler;
import com.jeff.spring.on.cloud.model.Crawler.HSBCCrawler;
import junit.framework.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aigens on 20/1/2016.
 */
public class TestCityBankCrawler extends TestCase {
//    public void testExtractComplexBenefit(){
//
//
//        List<String> benefits =  CityBankCrawler.extractBenefitDescription("1. 15% off dinner food items*#<br />\\n2. 10% off dinner food items#<br />\\n3. Complimentary 5 course tasting menu*^#<br />\\n<br />\\n*Applicable to Citi Platinum or above Credit Cards only.<br />\\n^Upon ordering 3 or above 5-course tasting menu and only applicable to any guest having birthday in that month.<br />\\n#Upon spending HK$800 (10% service charge excluded).");
//        this.assertTrue(true);
//    }
//    public void testExtractBenefit(){
//
//
//        List<String> benefits =  CityBankCrawler.extractBenefitDescription("晚市食品85折*#");
//        this.assertTrue(true);
//    }
    public void testPoi() throws IOException, ParseException {
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

//        DBSCrawler.crawCardTypes();
    }
}
