package com.github.kevinw831205.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200",
                                "http://localhost:8080",
                                "http://recipe-planner-frontend.s3-website-us-east-1.amazonaws.com",
                                "https://d1vuczoq7ekvcq.cloudfront.net"
                                )
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "HEAD");
            }
        };
    }
}
