package com.dklb.filius.infrastructure.config.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorRegister implements WebMvcConfigurer {

    @Autowired
    private InterceptorCustom interceptorCustom;

    @Value("${servicios.interceptor}")
    String[] serviciosInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(this.interceptorCustom)
                .addPathPatterns(serviciosInterceptor);

    }
}

