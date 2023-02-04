package com.course.kafka.kafkacoreproducer.scheduler;

import com.course.kafka.kafkacoreproducer.entity.Commodity;
import com.course.kafka.kafkacoreproducer.producer.CommodityProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommodityScheduler {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private CommodityProducer producer;

    @Scheduled(fixedRate =  5000)
    public void fetchCommodities(){
        var commodities = restTemplate.exchange("http://localhost:8080/api/commodity/v1/all", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Commodity>>() {
                }).getBody();
        CommodityProducer commodityProducer = producer;
        for (Commodity commodity : commodities) {
            try {
                commodityProducer.sendMessage(commodity);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

    }
}
