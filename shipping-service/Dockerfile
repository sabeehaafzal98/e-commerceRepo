FROM quay.io/quarkus/quarkus-jvm
COPY . /app
WORKDIR /app
RUN ./mvnw package
CMD ["java", "-jar", "target/shipping-service-runner.jar"]