# Use Maven image with Java 21
FROM maven:3.9-eclipse-temurin-21

# Set working directory
WORKDIR /app

# Copy pom.xml first (for better caching)
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the project
RUN mvn clean compile -B

# Default command - can be overridden when running
CMD ["mvn", "exec:java", "-Dexec.mainClass=com.conceptcoding.interviewquestions.bookmyshow.BookMyShowApp"]

