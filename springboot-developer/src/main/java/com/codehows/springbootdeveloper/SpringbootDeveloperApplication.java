package com.codehows.springbootdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //자바의 main() 메서드 역할
public class SpringbootDeveloperApplication {
    //첫 번째 인수는 스프링 부트3 어플의 메인 클래스로 사용할 클래스
    //두 번째 인수는 커맨드 라인의 인수들을 전달
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDeveloperApplication.class, args);
    }

}
