# OpenJDK 17 경량화 버전 사용
FROM openjdk:17-jdk-slim

# Gradle을 사용해 빌드를 실행하는 명령어
CMD ["./gradlew", "clean", "build"]

# 작업 디렉토리 설정
WORKDIR /apps

# 애플리케이션 jar 파일을 컨테이너로 복사
COPY build/libs/ezpz-admin-0.0.1-SNAPSHOT.jar /apps/app.jar

# 환경변수
#ENV DATASOURCE_URL=jdbc:mysql://ezpz-mysql.cpcu00kyiswk.ap-northeast-2.rds.amazonaws.com:3306/ezpz \
#DATASOURCE_USERNAME=root \
#DATASOURCE_PASSWORD=helloEzpz! \
#SERVER_PORT=8082 \
#JWT_SECRET_KEY=0878a3d01aad7c99051fd7687cddded9d138dc96cf767d9ef8753a62a2d7022820f956bf33d0d61c6f58cfe2176af8718675b2708a013207b27140bab3d456a0 \
#ACCESS_TOKEN_TTL=1000 \
#REFRESH_TOKEN_TTL=10000 \
#REDIS_HOST=host.docker.internal \
#REDIS_PORT=6379 \
#DDL_AUTO=none

# 애플리케이션이 사용할 포트 노출
EXPOSE 8082

# 애플리케이션을 실행하기 위한 엔트리포인트 정의
ENTRYPOINT ["java", "-jar", "/apps/app.jar"]