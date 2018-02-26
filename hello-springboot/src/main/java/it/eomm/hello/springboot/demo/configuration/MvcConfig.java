package it.eomm.hello.springboot.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


/**
 * Created by Manuel Spigolon on 20/10/2017.
 * <p>
 * implement WebMvcRegistrations: allow you to provide custom instances of RequestMappingHandlerMapping, RequestMappingHandlerAdapter or ExceptionHandlerExceptionResolver
 * implement WebMvcConfigurer: allow you to to keep Spring Boot MVC features, and to add additional MVC configuration (interceptors, formatters, view controllers etc.)
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // Another way for adding Converters like CustomHttpMessageConverters
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // I can add some static path to serve
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // I can add CORS (Cross-origin resource sharing) to some pattern
        registry.addMapping("/api/**");
    }

    /**
     * This configuration suppose you have added a template engine like thymeleaf.
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }

}
