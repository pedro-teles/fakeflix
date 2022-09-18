FROM openjdk

RUN mkdir -p /app
WORKDIR /app

COPY cinephile-standalone.jar .

EXPOSE 8080

CMD java -jar cinephile-standalone.jar
