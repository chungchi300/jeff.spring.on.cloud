package com.jeff.spring.on.cloud.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public  abstract class BenefitCrawler {

	protected List<String> urls;
	protected String language;
	protected List<Benefit> benefits;
	public BenefitCrawler(String language){
		this.urls = new ArrayList<String>();
		this.benefits = new ArrayList<Benefit>();
		this.language = language;
	}
	public List<String> getUrls() {
		return this.urls;
	}

	/**
	 * 
	 * @param url
	 */
	public void addUrl(String url) {
		this.urls.add(url);
	}

	public List<Benefit> getBenefits() {
		return this.benefits;
	}

	public abstract void craw() throws IOException;

}