package com.jeff.spring.on.cloud;

import com.jeff.spring.on.cloud.model.Benefit;
import com.jeff.spring.on.cloud.model.CSVFormatter;
import com.jeff.spring.on.cloud.model.CardBenefitsRepository;
import junit.framework.TestCase;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
    public void testExtractBenefit(){


        String str = StringUtils.substringAfter("../../english/credit-cards/images/logo/img1386.jpg","../../");
        this.assertTrue(true);
    }

    public void testPoi() throws IOException, ParseException {

        List<Benefit> benefits= new ArrayList<>();

//        BenefitCrawler.regexCaptureFirst(".?(\\d{8}).*","(852)27392080\n");
//     done   writeFile(CardBenefitsRepository.getInstance().crawCITY(), "Citibank.csv");
//          writeFile(CardBenefitsRepository.getInstance().crawAmericanExpress(), "American Express.csv");
//        writeFile(CardBenefitsRepository.getInstance().crawDBS(), "DBS.csv");
//        writeFile(CardBenefitsRepository.getInstance().crawHSBC(),"HSBC.csv");
        writeFile(CardBenefitsRepository.getInstance().crawSC(),"Standard Chatard.csv");
//        writeFile(CardBenefitsRepository.getInstance().crawHangSeng(),"Hang Seng Bank.csv");
//        writeFile(CardBenefitsRepository.getInstance().crawCCB(),"China Construction Bank (Asia).csv");

//        baos.writeTo(res.getOutputStream());
    }
    public void writeFile(List<Benefit> benefits,String fileName) throws IOException {

                    ByteArrayOutputStream baos = CSVFormatter.getInstance().convertBenefits(benefits);
                    OutputStream outputStream = new FileOutputStream(fileName);
                    baos.writeTo(outputStream);



    }
}
