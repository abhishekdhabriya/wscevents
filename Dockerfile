# Set the base image to Java 11
FROM openjdk:11

#File author/maintainer
MAINTAINER A.D

#Define default environment variables
ENV SRS_HOME=/srs/home
ENV SRS_BIN=/srs/srs/bin
ENV APP_SPRING_DATASOURCE_HOST: mysql
ENV APP_SPRING_PROFILES_ACTIVE: staging
ENV APP_DB_NAME: srs_${APP_SPRING_PROFILES_ACTIVE}_db
ENV APP_SECURITY_JWT_SECRET_KEY: srssecret

# Create path
RUN mkdir -p $SRS_BIN

# Set default working directory
WORKDIR $SRS_HOME

#Copy the core jar under working directory
COPY target/*.jar $SRS_HOME/srs-v0.0.1.jar

#Add initialization script
ADD entrypoint.sh $SRS_BIN/entrypoint.sh

#Update permission
RUN chmod 755 $SRS_BIN/entrypoint.sh

#Expose default servlet container port
EXPOSE 8400

#Main entry point command with arguments
ENTRYPOINT ["/bin/sh", "/srs/srs/bin/entrypoint.sh"]
