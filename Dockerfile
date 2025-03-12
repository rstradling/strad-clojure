# Build stage
FROM clojure:lein AS builder

# Set the working directory
WORKDIR /usr/src/app

# Copy the project file and fetch dependencies
COPY project.clj .
RUN lein deps

# Copy the rest of the application files
COPY . .

# Build the Uberjar
RUN mv "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app-standalone.jar

# Run-time stage
FROM eclipse-temurin:23-jre-ubi9-minimal

# Create a non-root user and group
RUN groupadd -r practicalli && useradd -r -g practicalli practicalli

# Create a directory for the service and change ownership
RUN mkdir -p /service && chown -R practicalli:practicalli /service

# Copy the Uberjar from the build stage
COPY --from=builder /usr/src/app/app-standalone.jar /service/

# Set the working directory
WORKDIR /service

# Expose the port the Clojure service listens on
EXPOSE 3000 

# Switch to the non-root user
USER practicalli

# Define the command to run the Clojure service
ENTRYPOINT ["java", "-jar", "app-standalone.jar"]
