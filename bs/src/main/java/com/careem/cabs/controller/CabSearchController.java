package com.careem.cabs.controller;

import com.careem.cabs.cce.algo.CCEClient;
import com.careem.cabs.cce.commons.domain.CabResult;
import com.careem.cabs.request.beans.CabBookBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

/**
 * Created by kvn.pavan on 2/25/17.
 */

@RestController
@RequestMapping("/v1/search")
public class CabSearchController {
    

    @RequestMapping(value = "/{customerId}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<CabResult>> search(@Valid @RequestBody CabBookBean cabBookBean) {
        CCEClient cceClient = new CCEClient();
        Set<CabResult> cabResults = cceClient.getCabList(cabBookBean.getLat(), cabBookBean.getLon(), cabBookBean.getMode(), cabBookBean.getCabType());
        return Optional.ofNullable(cabResults)
                       .map(result -> new ResponseEntity<>(
                               result,
                               HttpStatus.OK))
                       .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}