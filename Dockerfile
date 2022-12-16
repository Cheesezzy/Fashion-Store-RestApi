FROM openjdk:11
EXPOSE 8084
COPY ./target/fashion-blog-restapi.jar fashion-blog-restapi.jar
ENTRYPOINT ["java","-jar","/fashion-blog-restapi.jar"]