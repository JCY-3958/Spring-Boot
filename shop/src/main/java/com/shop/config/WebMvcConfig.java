package com.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//업로드한 파일을 읽어올 경로 설정
public class WebMvcConfig implements WebMvcConfigurer {

    //프로퍼티에 uploadPath 값을 가져옴
    @Value("${uploadPath}")
    String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //웹 브라우저 url이 /images로 시작하는 경우 uploadPath에 설정한 폴더 기준으로 파일을 읽어옴
        registry.addResourceHandler("/images/**")
                .addResourceLocations(uploadPath); //로컬 컴퓨터에 저장된 파일을 읽어올 root경로 설정
    }
}
