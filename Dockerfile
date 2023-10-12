FROM openjdk:17
LABEL authors="Sudongk"
# 프로젝트를 복사
#RUN ["mkdir", "project"]
#COPY . ./project
# 도커 파일안에서 빌드
#RUN ["chmod", "744", "./project/gradlew"]
#RUN ["./project/gradlew", "clean", "build", "--no-debug"]
COPY build/libs/*T.jar app.jar
# jar파일을 실행시킨다.
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]