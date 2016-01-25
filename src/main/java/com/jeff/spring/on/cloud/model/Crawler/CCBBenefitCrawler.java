package com.jeff.spring.on.cloud.model.Crawler;

import com.jeff.spring.on.cloud.model.Benefit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by aigens on 18/1/2016.
 */
public class CCBBenefitCrawler extends BenefitCrawler {
    public CCBBenefitCrawler(String language) {
        super(language);
    }

    @Override
    public void craw() throws IOException {
        for(String url:urls){

            Document doc = Jsoup.connect(url).get();
            Elements merchants = doc.select("#master > div.inner > table:nth-child(n+3) > tbody > tr:nth-child(odd)");

            for (Element merchant : merchants) {
                Benefit benefit = new Benefit();
                benefit.setLanguage(this.language);
                benefit.setBank("China Construction Bank");
                for(Element html:merchant.select("td:nth-child(2) > table > tbody > tr > td > table")){
                    benefit.addCard(html.text().replace("This merchant accepts ",""));

                }

                benefit.setMerchant(merchant.select("td:nth-child(2) > table > tbody > tr > td > h3").text());
                benefit.setMerchantPhone(merchant.select("td:nth-child(3) > table > tbody > tr > td > p.icoTel").text());
                for(Element html:merchant.select("td:nth-child(2) > table > tbody > tr > td > ul > li")){
                    String benefitDescription = html.text().replace("This merchant accepts ","");
                    benefit.addBenefitDescription(benefitDescription);

                }

                benefit.settAndCLink(url + merchant.select("a").attr("href"));

                try {
                    benefit.setFrom(new SimpleDateFormat("yyyy-MM-dd").parse("2016-01-01"));
                    benefit.setTo(new SimpleDateFormat("yyyy-MM-dd").parse("2016-12-31"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                for(Element html:merchant.select(".icoLocation")){
                    benefit.addStoreLocation(html.text());

                }

                this.benefits.add(benefit);
            }

        }
    }
}
