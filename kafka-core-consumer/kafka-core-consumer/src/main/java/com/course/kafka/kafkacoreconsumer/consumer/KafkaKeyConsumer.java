package com.course.kafka.kafkacoreconsumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class KafkaKeyConsumer {

    @KafkaListener(topics = "t-multi-partitions", concurrency = "2")
    public void consume(ConsumerRecord<String , String> consumerRecord) throws InterruptedException{
        System.out.println("Key : " + consumerRecord.key()
                + " Partition : " + consumerRecord.partition()
        + " Message : " + consumerRecord.value());
        TimeUnit.SECONDS.sleep(1);
    }
}
