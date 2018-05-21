FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD esky-boot-0.0.1.jar	esky.jar
RUN sh -c 'touch /esky.jar'
ENV JAVA_OPTS="-Dspring.profiles.active=prod"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /esky.jar"]