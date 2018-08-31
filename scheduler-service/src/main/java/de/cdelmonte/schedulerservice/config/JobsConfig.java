package de.cdelmonte.schedulerservice.config;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import de.cdelmonte.schedulerservice.events.producer.Producer;
import de.cdelmonte.schedulerservice.avro.Message;


@Component
public class JobsConfig {
  private static final String IMPORT_MERCHANTS = "IMPORT Merchants";

  @Autowired
  Producer messageSender;

  @Scheduled(fixedRateString = "${scheduler.import.merchants.fixed-rate.milliseconds}")
  public void importMerchants() {
    String uniqueId = UUID.randomUUID().toString();
    Message message = Message.newBuilder().setText(IMPORT_MERCHANTS).setId(uniqueId).build();
    messageSender.sendImportMerchantsMessage(message);
  }
}
