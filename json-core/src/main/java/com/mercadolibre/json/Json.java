package com.mercadolibre.json;

import com.mercadolibre.json.exception.JsonException;
import com.mercadolibre.json.type.TypeReference;

import java.util.List;
import java.util.Map;


public interface Json {

	Object getEngine();

	Object toJson(String jsonString) throws JsonException;
	List<Map<String, Object>> toJsonList(String jsonString) throws JsonException;
	Map<String, Object> toJsonMap(String jsonString) throws JsonException;

	Object toJson(byte[] jsonBytes) throws JsonException;
	List<Map<String, Object>> toJsonList(byte[] jsonBytes) throws JsonException;
	Map<String, Object> toJsonMap(byte[] jsonBytes) throws JsonException;

	<T> T toObject(String jsonString, Class<T> clazz) throws JsonException;
	<T> T toObject(Object json, Class<T> clazz) throws JsonException;
	<T> T toObject(byte[] jsonBytes, Class<T> clazz) throws JsonException;
	<T> T toObject(String jsonString, TypeReference<T> typeRef) throws JsonException;
	<T> T toObject(byte[] jsonBytes, TypeReference<T> typeRef) throws JsonException;
	<T> T toObject(Object json, TypeReference<T> typeRef) throws JsonException;

	<T> List<T> toObjectList(String jsonString, Class<T> clazz) throws JsonException;
	<T> List<T> toObjectList(byte[] jsonBytes, Class<T> clazz) throws JsonException;

	String toJsonString(Object json) throws JsonException;
	boolean validate(String jsonString);
	
}