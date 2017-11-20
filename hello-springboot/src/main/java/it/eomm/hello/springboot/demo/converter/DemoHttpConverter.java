package it.eomm.hello.springboot.demo.converter;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * This is a custom converter  for manager {@link MyObject} class responses
 * Created by Manuel Spigolon on 10/10/2017.
 */
public class DemoHttpConverter implements HttpMessageConverter<MyObject> {


    @Override
    public boolean canRead(Class<?> aClass, @Nullable MediaType mediaType) {
        return MyObject.class == aClass;
    }

    @Override
    public boolean canWrite(Class<?> aClass, @Nullable MediaType mediaType) {
        return MyObject.class == aClass;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Arrays.asList(MediaType.APPLICATION_JSON_UTF8, MediaType.TEXT_PLAIN);
    }

    @Override
    public MyObject read(Class<? extends MyObject> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(MyObject myObject, @Nullable MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        httpOutputMessage.getBody().write(("{customOutput: " + myObject.getMyString() + '}').getBytes());
    }
}
