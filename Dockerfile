# =========================
# Stage 1 — Build with Maven
# =========================
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY app ./app
COPY docs ./docs

RUN mvn -B clean package -DskipTests

# =========================
# Stage 2 — Runtime image
# =========================
FROM eclipse-temurin:17-jre

WORKDIR /app
# Copy the JAR built in the previous stage
COPY --from=build /app/app/startup/target/*.jar app.jar

# Expose the default port (Render uses $PORT env)
EXPOSE 8080

# Environment variable for Render (dynamic port)
ENV PORT=8080
ENV JAVA_OPTS=""

# Healthcheck for Docker (optional)
HEALTHCHECK --interval=30s --timeout=5s \
  CMD curl -f http://localhost:${PORT}/api/v1/osrs/actuator/health || exit 1

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar --server.port=${PORT}"]
