FROM openjdk:10-jdk
RUN apt-get update && apt-get -y upgrade
RUN mkdir -p /usr/local/scheduler-service
ADD @project.build.finalName@.jar /usr/local/scheduler-service/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
