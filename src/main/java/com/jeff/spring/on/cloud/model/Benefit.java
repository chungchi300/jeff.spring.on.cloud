package com.jeff.spring.on.cloud.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Benefit {

    private String id;
	private String language;
	private String bank;
	private List<String> cards = new ArrayList<String>();
	private String merchant;
	private String merchantPhone;


	private String tAndCLink;
	private Date from;
    private Date to;
	private List<String> storeLocations = new ArrayList<String>();
	private List<String> benefitDescriptions = new ArrayList<String>();


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public List<String> getCards() {
        return cards;
    }

    public void addCard(String card) {
        this.cards.add(card);
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getMerchantPhone() {
        return merchantPhone;
    }

    public void setMerchantPhone(String merchantPhone) {
        merchantPhone = merchantPhone.replace(" ","");
        this.merchantPhone = merchantPhone;
    }

    public String gettAndCLink() {
        return tAndCLink;
    }

    public void settAndCLink(String tAndCLink) {
        this.tAndCLink = tAndCLink;
    }



    public List<String> getStoreLocations() {
        return storeLocations;
    }

    public void addStoreLocation(String storeLocation) {
        this.storeLocations.add(storeLocation);
    }

    public List<String> getBenefitDescriptions() {
        return benefitDescriptions;
    }

    public void addBenefitDescription(String benefitDescription) {
        this.benefitDescriptions.add(benefitDescription);
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}