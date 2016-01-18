package com.jeff.spring.on.cloud;

import java.util.ArrayList;
import java.util.List;

public class Benefit {


	private String language;
	private String bank;
	private List<String> cards = new ArrayList<String>();
	private String merchant;
	private String merchantPhone;


	private String tAndCLink;
	private String period;
	private List<String> storeLocations = new ArrayList<String>();
	private List<String> benefitDescriptions = new ArrayList<String>();

    @Override
    public String toString() {
        return "Benefit{" +
                "language='" + language + '\'' +
                ", bank='" + bank + '\'' +
                ", cards=" + cards +
                ", merchant='" + merchant + '\'' +
                ", merchantPhone='" + merchantPhone + '\'' +
                ", tAndCLink='" + tAndCLink + '\'' +
                ", period='" + period + '\'' +
                ", storeLocations=" + storeLocations +
                ", benefitDescriptions=" + benefitDescriptions +
                '}';
    }

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
        this.merchantPhone = merchantPhone;
    }

    public String gettAndCLink() {
        return tAndCLink;
    }

    public void settAndCLink(String tAndCLink) {
        this.tAndCLink = tAndCLink;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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
}