package com.gdn.jvm.meetup.kafkademo.spring.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Eko Kurniawan Khannedy
 */
@EnableKafka
@SpringBootApplication
public class SpringConsumerApp {

  public static void main(String[] args) throws IOException {
    SpringApplication.run(SpringConsumerApp.class, args);

    System.in.read();
  }

  @Slf4j
  @Component
  public static class ConsumerApp {

    @KafkaListener(topics = "spring_topic", group = "kafka-demo")
    public void listen(ConsumerRecord<String, String> record) {
      log.info("receive {}:{} from partition {}", record.key(), record.value(), record.partition());
    }

  }
}
