package com.careem.cabs.request.beans;

import com.careem.cabs.cce.commons.utils.BookingMode;
import com.careem.cabs.cce.commons.utils.CabType;

/**
 * Created by kvn.pavan on 2/25/17.
 */
public class CabBookBean {
    private Double lat;
    private Double lon;
    private BookingMode mode;
    private CabType cabType;

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

    public BookingMode getMode() {
        return mode;
    }

    public void setMode(BookingMode mode) {
        this.mode = mode;
    }

    public CabType getCabType() {
        return cabType;
    }

    public void setCabType(CabType cabType) {
        this.cabType = cabType;
    }
}
