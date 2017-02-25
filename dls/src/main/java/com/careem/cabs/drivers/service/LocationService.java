package com.careem.cabs.drivers.service;

import com.careem.cabs.drivers.clients.ElasticsearchClient;
import com.careem.cabs.drivers.domain.CabLocationDetailsDomain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexResponse;

/**
 * Created by 17803 on 25/02/17.
 */
public class LocationService {

    public void updateDriverLocation(CabLocationDetailsDomain locationDomain) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        byte[] input = mapper.writeValueAsBytes(locationDomain);
        IndexResponse response = ElasticsearchClient.indexDocument(input, locationDomain.getId());
        System.out.print(response);
    }
}
