FROM openjdk:18.0.1
LABEL maintainer="muchirinephat5@gmail.com"
ENV PORT=8000
#
ARG JAR_FILE=target/currency-exchange.jar
ADD ${JAR_FILE} currency-exchange.jar

COPY target/*.jar /opt/currency-exchange.jar
ENTRYPOINT ["java","-jar","/currency-exchange.jar"]
