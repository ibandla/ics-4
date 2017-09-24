FROM jetty:alpine
COPY target/ics4-0.0.2.jar /src/ics4.jar
ENTRYPOINT ["java","-jar","/src/ics4.jar"]
