package com.careem.cabs.cce.algo;

import com.careem.cabs.cce.commons.domain.CabResult;
import com.careem.cabs.cce.commons.utils.BookingMode;
import com.careem.cabs.cce.commons.utils.CabType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;

import java.util.*;

import static org.elasticsearch.index.query.QueryBuilders.geoDistanceQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

/**
 * Created by kvn.pavan on 2/25/17.
 */
public class CCEClient implements IClient {

    @Override
    public Set<CabResult> getCabList(Double lat, Double lon, BookingMode mode, CabType cabType) {
        TransportClient transportClient = ESClient.getInstance();
        SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch("careemcabs");

        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
                                                 .must(matchQuery("cabType", cabType.toString()))
                                                 .must(matchQuery("bookingMode", mode.toString()))
                                                 .filter(geoDistanceQuery("location").point(lat, lon).distance(2, DistanceUnit.KILOMETERS));


        //sort by distance and rating descending
        searchRequestBuilder.setQuery(queryBuilder)
                            .addSort(SortBuilders.geoDistanceSort("location", lat, lon).order(SortOrder.ASC).unit(DistanceUnit.KILOMETERS));
//                            .addSort(SortBuilders.fieldSort("rating").order(SortOrder.DESC));

        SearchResponse searchResponse = searchRequestBuilder.execute().actionGet();

        SearchHit[] results = searchResponse.getHits().getHits();

        Set<CabResult> cabResults = new LinkedHashSet<>();
        for(SearchHit hit : results){
            Map<String, Object> hitResult = hit.getSource();

            CabResult cabResult = new CabResult();

            String cabId = (String) hitResult.get("id");
//            Integer rating = hit.field("rating").<Integer>getValue();
            Double cabLat = (Double) ((Map)hitResult.get("location")).get("lat");
            Double cabLong = (Double) ((Map)hitResult.get("location")).get("lon");

            cabResult.setBookingMode(mode);
            cabResult.setCabId(cabId);
            cabResult.setCabType(cabType);
            cabResult.setLat(cabLat);
            cabResult.setLon(cabLong);
//            cabResult.setRating(rating);

            cabResults.add(cabResult);
            /*String sourceAsString = hit.getSourceAsString();
            if (sourceAsString != null) {
                Gson gson = new GsonBuilder().create();
                System.out.println( gson.fromJson(sourceAsString, CabResult.class));
            }*/
        }

        return cabResults;
    }

    @Override
    public CabResult getBestCab(Double lat, Double lon, BookingMode mode, CabType cabType) {
        Set<CabResult> results = getCabList(lat, lon, mode, cabType);
        if(results != null && !results.isEmpty()) {
            return results.iterator().next();
        }
        return null;
    }
}
