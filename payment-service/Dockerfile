FROM quay.io/quarkus/quarkus-jvm
COPY . /app
WORKDIR /app
RUN ./mvnw package
CMD ["java", "-jar", "target/payment-service-runner.jar"]