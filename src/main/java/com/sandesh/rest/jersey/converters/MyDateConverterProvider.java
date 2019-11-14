package com.sandesh.rest.jersey.converters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import com.sandesh.rest.jersey.models.MyDate;

@Provider
public class MyDateConverterProvider implements ParamConverterProvider{

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
		
		// Cast the type to date if something is passed and the accepted type is MyDate instance
		if (rawType.getName().equals(MyDate.class.getName())) {
			return new ParamConverter<T>() {

				@Override
				public T fromString(String value) {
					Calendar calendar = Calendar.getInstance();
					if ("tomorrow".equals(value)) calendar.add(Calendar.DATE, 1);
					else if ("yesterday".equals(value)) calendar.add(Calendar.DATE, -1);
					MyDate mydate = new MyDate(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
					return rawType.cast(mydate);
				}

				@Override
				public String toString(T value) {
					if (value == null) return null;
					return value.toString();
				}
			};
		}
		return null;
	}

}
