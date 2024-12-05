# This Dockerfile builds and runs a Java application using Payara Micro and Eclipse Temurin JDK 21.
# 
# ARG PAYARA_VERSION=6.2024.11-jdk21
# - Defines the version of Payara Micro to be used.
#
# FROM eclipse-temurin:21-jdk AS build
# - Uses Eclipse Temurin JDK 21 as the base image for the build stage.
#
# WORKDIR /app
# - Sets the working directory to /app.
#
# COPY . /app
# - Copies the entire project into the /app directory in the container.
#
# RUN --mount=type=cache,target=/root/.m2 ./mvnw -Dskiptest package
# - Uses Maven Wrapper to build the project, skipping tests, and caches dependencies.
#
# FROM payara/micro:${PAYARA_VERSION}
# - Uses the specified version of Payara Micro as the base image for the runtime stage.
#
# COPY --from=build /app/target/*war ${DEPLOY_DIR}/
# - Copies the built WAR file from the build stage to the deployment directory in the runtime stage.
#
# ENTRYPOINT java -jar ${PAYARA_DIR}/payara-micro.jar --deploy ${DEPLOY_DIR}/*.war
# - Sets the entry point to run Payara Micro and deploy the WAR file.
ARG PAYARA_VERSION=6.2024.11-jdk21

FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . /app
RUN --mount=type=cache,target=/root/.m2 ./mvnw -Dskiptest package

FROM payara/micro:${PAYARA_VERSION}
COPY --from=build /app/target/*war ${DEPLOY_DIR}/
ENTRYPOINT java -jar ${PAYARA_DIR}/payara-micro.jar \
                            --deploy ${DEPLOY_DIR}/*.war