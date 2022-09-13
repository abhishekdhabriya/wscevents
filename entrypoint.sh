#!/bin/bash
set -e

# Marketplace core application with specific JVM_ARGS and SPRING_PROFILE
java ${JVM_ARGS} -jar -Dspring.profiles.active=${APP_SPRING_PROFILES_ACTIVE}  -Ddb_name=${APP_DB_NAME}  ${SRS_HOME}/srs-v0.0.1.jar
