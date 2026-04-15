FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw || true
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests

EXPOSE 8081

CMD ["java", "-jar", "target/birth-registration-backend-0.0.1-SNAPSHOT.jar"]