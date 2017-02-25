package com.careem.cabs.drivers.domain;

import java.io.Serializable;

/**
 * Created by 17803 on 25/02/17.
 */
public class LocationDomain implements Serializable {
    private Double lat;
    private Double lon;

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
}
