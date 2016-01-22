package com.jeff.spring.on.cloud.model.Crawler;

import com.jeff.spring.on.cloud.model.Benefit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aigens on 22/1/2016.
 */
public class HSBCCrawler extends BenefitCrawler {
    public HSBCCrawler(String language) {
        super(language);
    }

    @Override
    public void craw() throws IOException, ParseException {
        for (String url : urls) {

            Document doc = Jsoup.connect(url).get();
            Elements merchants = doc.select(".yroContent > .yro-promo-block");
            List<Benefit> benefits = new ArrayList<Benefit>();
            for (Element merchant : merchants) {
                String merchantHtml = merchant.html();
                Benefit benefit = new Benefit();
                benefit.setLanguage(this.language);
                benefit.setBank("hsbc");
                benefit.addCard("匯豐卓越理財信用卡");
                benefit.addCard("匯豐運籌理財信用卡");
                benefit.addCard("匯豐白金信用卡");
                benefit.addCard("其他匯豐信用卡");
                try {
                    benefit.setFrom(new SimpleDateFormat("yyyy-MM-dd").parse("2016-01-01"));
                    benefit.setTo(new SimpleDateFormat("yyyy-MM-dd").parse("2016-12-31"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String title = merchant.select(".title").html();
                benefit.setMerchant(title);
            }

        }
    }
}
