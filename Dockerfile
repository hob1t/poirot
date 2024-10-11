FROM openjdk:17
LABEL org.uofpeople.poirot.image.authors="h0b1t202202@gmail.com"
COPY build/libs/poirot-0.0.1-SNAPSHOT.jar poirot-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/poirot-0.0.1-SNAPSHOT.jar"]