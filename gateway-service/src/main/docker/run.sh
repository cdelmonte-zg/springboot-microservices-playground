#!/bin/sh

echo "********************************************************"
echo "Starting Zuul Service with $SERVER_PORT"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -Dserver.port=$SERVER_PORT \
     -Deureka.client.serviceUrl.defaultZone=$EUREKASERVER_URI \
     -Dspring.cloud.config.uri=$CONFIGSERVER_URI \
     -Dspring.profiles.active=$PROFILE \
     -Dspring.zipkin.baseUrl=$ZIPKIN_URI \
     -Dsigning.key=$SIGNING_KEY \
     -jar /usr/local/zuulservice/@project.build.finalName@.jar
