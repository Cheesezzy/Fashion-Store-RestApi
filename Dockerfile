FROM openjdk:8
EXPOSE 8080
ADD target/fashion-blog-restapi.jar fashion-blog-restapi
ENTRYPOINT ["java","-jar","/fashion-blog-restapi.jar "]