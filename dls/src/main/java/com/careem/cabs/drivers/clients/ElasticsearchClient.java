package com.careem.cabs.drivers.clients;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by 17803 on 25/02/17.
 */
public class ElasticsearchClient {
    private static Client elasticsearchClient = null;

    static {
        if(elasticsearchClient == null) {
            try {
                elasticsearchClient = new PreBuiltTransportClient(Settings.EMPTY)
                        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public static Client getClient() {
        return elasticsearchClient;
    }

    public static void closeClient() {
        elasticsearchClient.close();
    }

    public static IndexResponse indexDocument(byte[] inputData, String id) {
        IndexResponse response = elasticsearchClient.prepareIndex("careemcabs", "drivers", id)
        .setSource(inputData)
        .get();
        return response;
    }
}
