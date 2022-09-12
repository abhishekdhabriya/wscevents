#!/bin/bash
set -e

SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE:-dev}

# Marketplace core application with specific JVM_ARGS and SPRING_PROFILE
java ${JVM_ARGS} -jar -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} ${SRS_HOME}/srs-v0.0.1.jar
