package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
 
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	System.out.println("CORS\n\n\n");
        registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*");
        //registry.addMapping("/**").allowedHeaders("*");
    }
}