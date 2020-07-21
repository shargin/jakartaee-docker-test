FROM openliberty/open-liberty:20.0.0.6-kernel-java14-openj9-ubi

COPY src/main/liberty/config/server.xml /config/
COPY src/main/liberty/config/postgresql-42.2.14.jar /config

COPY target/web.war /config/dropins/