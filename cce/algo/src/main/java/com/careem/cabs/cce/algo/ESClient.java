package com.careem.cabs.cce.algo;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by kvn.pavan on 2/25/17.
 */
public class ESClient {

    private static volatile TransportClient transportClient = null;

    public synchronized static TransportClient getInstance() {
        if(transportClient == null) {
            try {
                transportClient = new PreBuiltTransportClient(Settings.EMPTY)
                        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

        }
        return transportClient;
    }

    public static void main(String[] args) {
        getInstance();
    }

}
