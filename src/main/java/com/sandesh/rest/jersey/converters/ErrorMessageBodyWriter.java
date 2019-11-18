package com.sandesh.rest.jersey.converters;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.sandesh.rest.jersey.models.ErrorMessage;

@Provider
public class ErrorMessageBodyWriter implements MessageBodyWriter<ErrorMessage>{

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return type.getName() == ErrorMessage.class.getName();
	}

	@Override
	public void writeTo(ErrorMessage errMessage, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		entityStream.write(errMessage.toString().getBytes());
	}

}
