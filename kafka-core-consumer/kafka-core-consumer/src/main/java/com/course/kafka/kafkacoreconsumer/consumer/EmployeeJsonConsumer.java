package com.course.kafka.kafkacoreconsumer.consumer;

import com.course.kafka.kafkacoreconsumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJsonConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "t-employee")
    public void listen(String message) throws JsonProcessingException {
        var employee = objectMapper.readValue(message, Employee.class);
        System.out.println(employee);
    }
}
