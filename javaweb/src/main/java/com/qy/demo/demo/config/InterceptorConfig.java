package com.qy.demo.demo.config;

import com.qy.demo.demo.jwt.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer  {

  @Bean
  public AuthenticationInterceptor authenticationInterceptor() {
      return new AuthenticationInterceptor();
  }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.authenticationInterceptor())
                .addPathPatterns("/**");
    }

}