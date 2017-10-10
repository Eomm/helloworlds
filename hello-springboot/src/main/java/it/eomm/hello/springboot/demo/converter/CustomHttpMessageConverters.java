package it.eomm.hello.springboot.demo.converter;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Manuel Spigolon on 10/10/2017.
 */
// Indicates that a class declares one or more @Bean methods and may be processed
// by the Spring container to generate bean definitions and service requests for those beans at runtime.
@Configuration
public class CustomHttpMessageConverters {

    /**
     * By default, the following HttpMessageConverters instances are pre-enabled:
     * <p>
     * ByteArrayHttpMessageConverter – converts byte arrays
     * StringHttpMessageConverter – converts Strings
     * ResourceHttpMessageConverter – converts org.springframework.core.io.Resource for any type of octet stream
     * SourceHttpMessageConverter – converts javax.xml.transform.Source
     * FormHttpMessageConverter – converts form data to/from a MultiValueMap<String, String>.
     * Jaxb2RootElementHttpMessageConverter – converts Java objects to/from XML (added only if JAXB2 is present on the classpath)
     * MappingJackson2HttpMessageConverter – converts JSON (added only if Jackson 2 is present on the classpath)
     * MappingJacksonHttpMessageConverter – converts JSON (added only if Jackson is present on the classpath)
     * AtomFeedHttpMessageConverter – converts Atom feeds (added only if Rome is present on the classpath)
     * RssChannelHttpMessageConverter – converts RSS feeds (added only if Rome is present on the classpath)
     *
     * @return add a custom converter
     */
    @Bean
    public HttpMessageConverters customConverters() {
        return new HttpMessageConverters(new DemoHttpConverter());
    }

}
