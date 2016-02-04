package com.jeff.spring.on.cloud.model.Crawler;

import com.google.gson.Gson;
import com.jeff.spring.on.cloud.model.Benefit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BenefitCrawler {

    protected List<String> urls;
    protected String language;
    protected List<Benefit> benefits;
    private List<RawData> rawDatas;
    public BenefitCrawler(String language) {
        this.urls = new ArrayList<String>();
        this.benefits = new ArrayList<Benefit>();
        this.language = language;
    }

    public Gson gson = new Gson();

    public List<String> getUrls() {
        return this.urls;
    }

    public String jsonPToJson(String jsonp, String wrapper) {
        jsonp = jsonp.replace("'\n'", "").replace("'\r'", "");
        Pattern pattern = Pattern.compile(wrapper + "\\((.*)\\);");
        Matcher matcher = pattern.matcher(jsonp);
        String json = "";
        if (matcher.find()) {
            json = matcher.group(1);

        }
        return json;
    }


    public String loadHtml(String link) throws IOException {
        URL url = new URL(link);

        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;
        String json = "";
        StringBuilder stringBuilder = new StringBuilder();
        //todo performance killer
        while ((inputLine = in.readLine()) != null)
            stringBuilder.append(inputLine);
        json = stringBuilder.toString();
        in.close();
        return json;
    }

    public void addUrl(String url) {
        this.urls.add(url);
    }

    public List<Benefit> getBenefits() {
        return this.benefits;
    }

    public static String regexCaptureFirst(Pattern pattern, String target) {
        String result = "";
        try {
            Pattern generatedPattern = pattern;
            Matcher matcher = generatedPattern.matcher(target);
            matcher.find();
            result = matcher.group(1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static String regexCaptureFirst(String strPattern, String target) {
        return regexCaptureFirst(Pattern.compile(strPattern), target);
    }

    public abstract void craw() throws IOException, ParseException;


    public List<RawData> getRawDatas() {
        return rawDatas;
    }

    public void setRawDatas(List<RawData> rawDatas) {
        this.rawDatas = rawDatas;
    }
}