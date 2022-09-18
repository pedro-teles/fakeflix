FROM openjdk

RUN mkdir -p /app
WORKDIR /app

COPY minions-standalone.jar .

EXPOSE 8080

CMD java -jar minions-standalone.jar
