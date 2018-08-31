#!/bin/sh

echo "spring.cloud.config.server.git.username=$CONFIG_REPO_USERNAME"
echo "spring.cloud.config.server.git.password=$CONFIG_REPO_PASSWORD"
echo "spring.cloud.config.server.git.uri=$CONFIG_REPO_URI"

java -Djava.security.egd=file:/dev/./urandom \
	-Dsigning.key=$SIGNING_KEY \
	-Deureka.client.serviceUrl.defaultZone=$EUREKASERVER_URI \
	-Dspring.profiles.active=$PROFILE \
    -Dspring.cloud.config.server.git.username=$CONFIG_REPO_USERNAME\
	-Dspring.cloud.config.server.git.password=$CONFIG_REPO_PASSWORD\
	-Dspring.cloud.config.server.git.uri=$CONFIG_REPO_URI\
    -Dspring.zipkin.baseUrl=$ZIPKIN_URI\
	-jar /usr/local/configserver/@project.build.finalName@.jar
