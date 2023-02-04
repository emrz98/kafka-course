package com.course.kafka.kafkacoreproducer;

import com.course.kafka.kafkacoreproducer.entity.Employee;
import com.course.kafka.kafkacoreproducer.producer.EmployeeJsonProducer;
import com.course.kafka.kafkacoreproducer.producer.HelloKafkaProducer;
import com.course.kafka.kafkacoreproducer.producer.KafkaKeyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class KafkaCoreProducerApplication implements CommandLineRunner {

	/*@Autowired
	private KafkaKeyProducer producer;*/

	@Autowired
	private EmployeeJsonProducer producer;


	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 5; i++) {
			var emp = new Employee("emp-"+i, "Employee"+i, LocalDate.now());
			producer.sendMessage(emp);
		}
	}
}
