FROM openjdk

RUN mkdir -p /app
WORKDIR /app

COPY scout-standalone.jar .

EXPOSE 8080

CMD java -jar scout-standalone.jar
