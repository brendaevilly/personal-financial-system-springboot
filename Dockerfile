# Etapa 1: build da aplicação (opcional, se quiser fazer o build via Docker)
# FROM maven:3.9.6-eclipse-temurin-17 AS builder
# WORKDIR /app
# COPY . .
# RUN mvn clean package -DskipTests

# Etapa 2: imagem final com JAR
FROM eclipse-temurin:21-jdk-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR gerado localmente
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar o app
ENTRYPOINT ["java", "-jar", "app.jar"]
