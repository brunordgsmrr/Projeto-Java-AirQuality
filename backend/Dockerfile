# Etapa 1: Build da aplicação usando Maven e Java 21
FROM maven:3.9.4-eclipse-temurin-21 AS build

WORKDIR /app

# Copia o código-fonte
COPY . .

# Faz o build do projeto, gerando o .jar
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final para execução
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Copia o JAR gerado
COPY --from=build /app/target/api-java-airquality-0.0.1-SNAPSHOT.jar app.jar

# Expondo a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar o Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
