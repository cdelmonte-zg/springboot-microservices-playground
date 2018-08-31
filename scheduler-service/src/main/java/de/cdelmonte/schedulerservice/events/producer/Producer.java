package de.cdelmonte.schedulerservice.events.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import de.cdelmonte.schedulerservice.avro.Message;


public class Producer {
  private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

  @Value("${kafka.topic.import-merchants}")
  private String importMerchantstopic;

  @Autowired
  private KafkaTemplate<String, Message> kafkaTemplate;

  public void sendImportMerchantsMessage(Message message) {
    LOGGER.info("sending message='{}'", message);
    try {
      ProducerRecord<String, Message> record =
          new ProducerRecord<>(importMerchantstopic, message);
      kafkaTemplate.send(record);
    } catch (Exception e) {
      LOGGER.debug("Error sending message. {}", e.getMessage());
    }
  }
}
