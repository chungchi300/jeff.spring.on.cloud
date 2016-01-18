package com.jeff.spring.on.cloud;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

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
                benefit.setBank("ccb");
                for(Element html:merchant.select("td:nth-child(2) > table > tbody > tr > td > table")){
                    benefit.addCard(html.text());

                }

                benefit.setMerchant(merchant.select("td:nth-child(2) > table > tbody > tr > td > h3").text());
                benefit.setMerchantPhone(merchant.select("td:nth-child(3) > table > tbody > tr > td > p.icoTel").text());
                for(Element html:merchant.select("td:nth-child(2) > table > tbody > tr > td > ul > li")){
                    benefit.addBenefitDescription(html.text());

                }

                benefit.settAndCLink("http://www.asia.ccb.com/hongkong_tc/personal/credit_cards/yearroundoffers/diningchi/index_content.html" + merchant.select("a").attr("href"));
                benefit.setPeriod(merchant.select(".icoPromo").text());
                for(Element html:merchant.select(".icoLocation")){
                    benefit.addStoreLocation(html.text());

                }

                this.benefits.add(benefit);
            }

        }
    }
}
