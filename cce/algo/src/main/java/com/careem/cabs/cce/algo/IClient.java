package com.careem.cabs.cce.algo;


import com.careem.cabs.cce.commons.domain.CabResult;
import com.careem.cabs.cce.commons.utils.BookingMode;
import com.careem.cabs.cce.commons.utils.CabType;

import java.util.Set;

/**
 * Created by kvn.pavan on 2/25/17.
 */
public interface IClient {

    public Set<CabResult> getCabList(Double lat, Double lon, BookingMode mode, CabType cabType);

    public CabResult getBestCab(Double lat, Double lon, BookingMode mode, CabType cabType);
}
