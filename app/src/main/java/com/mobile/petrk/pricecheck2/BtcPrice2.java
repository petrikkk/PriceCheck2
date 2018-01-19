package com.mobile.petrk.pricecheck2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BtcPrice2 {

    @SerializedName("high")
    @Expose
    private String high;
    @SerializedName("last")
    @Expose
    private String last;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("bid")
    @Expose
    private String bid;
    @SerializedName("vwap")
    @Expose
    private String vwap;
    @SerializedName("volume")
    @Expose
    private String volume;
    @SerializedName("low")
    @Expose
    private String low;
    @SerializedName("ask")
    @Expose
    private String ask;
    @SerializedName("open")
    @Expose
    private Double open;

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getVwap() {
        return vwap;
    }

    public void setVwap(String vwap) {
        this.vwap = vwap;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

}
