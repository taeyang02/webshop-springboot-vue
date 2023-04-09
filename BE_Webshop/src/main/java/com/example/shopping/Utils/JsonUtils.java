package com.example.shopping.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JsonUtils {
	private static ObjectMapper objectMapper;
	//private static ObjectMapper objectMapper = new ObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	
	@Autowired
	public JsonUtils(ObjectMapper objectMapper) {
		JsonUtils.objectMapper = objectMapper;
	}
	
	public static <T> T fromJson(String json, Class<T> classOfT) throws JsonProcessingException {
		return objectMapper.readValue(json, classOfT);
	}
	
	public static <T> T fromJson(String json, TypeReference<T> typeOfT) throws JsonProcessingException {
		return objectMapper.readValue(json, typeOfT);
	}

	public static <T> String toJson(T t) {
		try {
			return objectMapper.writeValueAsString(t);
		} catch (JsonProcessingException e) {
			return null;
		}
	}
	
	public static class JsonBuilder {
		private Map<String, Object> values = new HashMap<String, Object>();

		public JsonBuilder put(String name, String value) {
			values.put(name, value);
			return this;
		}

		public JsonBuilder put(String name, int value) {
			values.put(name, value);
			return this;
		}

		public JsonBuilder put(String name, long value) {
			values.put(name, value);
			return this;
		}
		
		public JsonBuilder put(String name, Object value) {
			values.put(name, value);
			return this;
		}

		public String build() {
			return JsonUtils.toJson(values);
		}
	}
}
