FROM openjdk:10-jdk
RUN apt-get update && apt-get -y upgrade && apt-get -y install netcat
RUN mkdir -p /usr/local/zuulservice
ADD @project.build.finalName@.jar /usr/local/zuulservice/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
