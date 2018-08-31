#!/bin/sh

java -Djava.security.egd=file:/dev/./urandom -Dspring.kafka.bootstrap-servers=$KAFKA_BOOTSTRAP_SERVERS \
	-Dspring.kafka.schema-registry=$SCHEMA_REGISTRY_SVR \
	-Dscheduler.import.merchants.fixed-rate.milliseconds=$FIXED_RATE_MILLISECONDS \
	-jar /usr/local/scheduler-service/@project.build.finalName@.jar
