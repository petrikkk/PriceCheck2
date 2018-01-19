package com.mobile.petrk.pricecheck2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BtcPrice {

    @SerializedName("BTC")
    @Expose
    private Double bTC;
    @SerializedName("USD")
    @Expose
    private Double uSD;
    @SerializedName("EUR")
    @Expose
    private Double eUR;

    public Double getBTC() {
        return bTC;
    }

    public void setBTC(Double bTC) {
        this.bTC = bTC;
    }

    public Double getUSD() {
        return uSD;
    }

    public void setUSD(Double uSD) {
        this.uSD = uSD;
    }

    public Double getEUR() {
        return eUR;
    }

    public void setEUR(Double eUR) {
        this.eUR = eUR;
    }

}
