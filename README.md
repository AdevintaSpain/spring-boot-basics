[![CI](https://github.com/AdevintaSpain/spring-boot-basics/actions/workflows/gradle.yml/badge.svg?branch=master)](https://github.com/AdevintaSpain/spring-boot-basics/actions/workflows/gradle.yml)

# Spring Boot Basics

Created with [this spring initialzr configuration](https://start.spring.io/#!type=gradle-project&language=kotlin&platformVersion=2.6.3&packaging=jar&jvmVersion=11&groupId=com.adevinta&artifactId=springbootbasics&name=springbootbasics&description=Do%20The%20Backend%20-%20Spring%20Boot%20Basics&packageName=com.adevinta.springbootbasics&dependencies=web,cloud-starter)

## Test

```shell
./gradlew test
```

## Run

```shell
./gradlew bootRun

curl -w'\n' -v http://localhost:8080/hello
```

## Documentation

* [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
* [Spring Boot Externalized Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config)