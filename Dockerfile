FROM jetty:alpine
COPY target/ics4-*.jar /src/ics4.jar
ENTRYPOINT ["java","-jar","/src/ics4.jar"]
