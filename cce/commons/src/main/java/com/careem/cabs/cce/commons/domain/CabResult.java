package com.careem.cabs.cce.commons.domain;

import com.careem.cabs.cce.commons.utils.BookingMode;
import com.careem.cabs.cce.commons.utils.CabType;

/**
 * Created by kvn.pavan on 2/25/17.
 */
public class CabResult {

    private String cabId;

    private Double lat;

    private Double lon;

    private CabType cabType;

    private BookingMode bookingMode;

    public String getCabId() {
        return cabId;
    }

    public void setCabId(String cabId) {
        this.cabId = cabId;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public CabType getCabType() {
        return cabType;
    }

    public void setCabType(CabType cabType) {
        this.cabType = cabType;
    }

    public BookingMode getBookingMode() {
        return bookingMode;
    }

    public void setBookingMode(BookingMode bookingMode) {
        this.bookingMode = bookingMode;
    }

}
