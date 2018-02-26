package it.eomm.hello.springboot.demo;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Read all the properties before @ConfigurationProperties bean
 * Created by Manuel Spigolon on 31/07/2017.
 */
@Component
@ConfigurationPropertiesBinding
public class PropertiesConverter implements Converter<String, String> {


    @Nullable
    @Override
    public String convert(String source) {
        if (source == null) {
            return null;
        }
        return source.toUpperCase();
    }
}
