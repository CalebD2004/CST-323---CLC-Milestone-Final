package com.cst323.milestone2.milestone2;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoggerService implements WebMvcConfigurer {


    // allows the ProgramLogger interceptor to be registered with the application
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ProgramLogger())
        .excludePathPatterns("/styles/**");
    }
}
