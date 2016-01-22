package com.jeff.spring.on.cloud;

import com.jeff.spring.on.cloud.model.Crawler.DBSCrawler;
import junit.framework.TestCase;

import java.io.IOException;
import java.text.ParseException;

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
        DBSCrawler dbsCrawler = new DBSCrawler("en");
        dbsCrawler.craw();
//        DBSCrawler.crawCardTypes();
    }
}
