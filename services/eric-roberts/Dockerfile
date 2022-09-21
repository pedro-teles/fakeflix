FROM amazoncorretto:11.0.16

RUN mkdir -p /app
WORKDIR /app

COPY eric-roberts-standalone.jar .

EXPOSE 8080

CMD java -jar eric-roberts-standalone.jar
