package com.course.kafka.kafkacoreproducer.api;

import com.course.kafka.kafkacoreproducer.entity.Commodity;
import com.course.kafka.kafkacoreproducer.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/commodity/v1")
public class CommodityApi {

    @Autowired
    private CommodityService commodityService;

    @GetMapping(value = "/all")
    public List<Commodity> generateAllCommodities(){
        return commodityService.createDummyCommodities();
    }


}
