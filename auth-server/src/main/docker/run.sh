#!/bin/sh

echo "********************************************************"
echo "Waiting for the configuration server to start on port $CONFIGSERVER_PORT"
echo "********************************************************"
while ! `nc -z configserver $CONFIGSERVER_PORT`; do sleep 3; done
echo "*******  Configuration Server has started"

java -Djava.security.egd=file:/dev/./urandom -Dserver.port=$SERVER_PORT \
    -Deureka.client.serviceUrl.defaultZone=$EUREKASERVER_URI \
    -Dspring.cloud.config.uri=$CONFIGSERVER_URI \
    -Dspring.zipkin.baseUrl=$ZIPKIN_URI\
    -Dspring.profiles.active=$PROFILE \
	-Dsigning.key=$SIGNING_KEY \
	-Dsecurity.oauth2.user.middlelayer.client=$MIDDLELAYER_CLIENT \
	-Dsecurity.oauth2.user.middlelayer.pwd=$MIDDLELAYER_PWD \
    -jar /usr/local/authenticationservice/@project.build.finalName@.jar
