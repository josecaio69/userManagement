# Estágio de build
FROM maven:3.9.6-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio de execução
FROM amazoncorretto:17.0.12-al2023-headless
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Variáveis de ambiente (valores padrão - serão sobrescritos pelo compose)
ENV SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/bd_users?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=root@2025
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_DATASOURCE_DRIVER-CLASS-NAME=com.mysql.cj.jdbc.Driver
ENV SPRING_SQL_INIT_MODE=always

# Saúde da aplicação (opcional)
HEALTHCHECK --interval=30s --timeout=3s \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]