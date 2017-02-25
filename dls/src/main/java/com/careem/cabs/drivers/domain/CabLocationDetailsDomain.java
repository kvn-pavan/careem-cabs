package com.careem.cabs.drivers.domain;

import com.careem.cabs.drivers.enums.BookingMode;
import com.careem.cabs.drivers.enums.CabType;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 17803 on 25/02/17.
 */
public class CabLocationDetailsDomain implements Serializable {

    private String id;
    private Date time;
    private CabType cabType;
    private BookingMode bookingMode;
    private LocationDomain location;
    private Integer rating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public LocationDomain getLocation() {
        return location;
    }

    public void setLocation(LocationDomain location) {
        this.location = location;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
