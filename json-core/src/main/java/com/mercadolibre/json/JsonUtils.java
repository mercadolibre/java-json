package com.mercadolibre.json;

import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

import com.mercadolibre.json.exception.JsonException;
import com.mercadolibre.json.type.TypeReference;


public enum JsonUtils implements Json {
	INSTANCE;
	
	private static Json instance;
	private static ServiceLoader<Json> loader = ServiceLoader.load(Json.class);
	
    static {
        load();
    }
    
    private static void load() {
        for (Json json : loader) {
            if (instance != null) throw new IllegalStateException("Many json implementations found");

            instance = json;
        }
    }

    @Override
	public Object getEngine() {
		return instance.getEngine();
	}

	@Override
    public Object toJson(String jsonString) throws JsonException {
		return instance.toJson(jsonString);
	}

	@Override
	public List<Map<String, Object>> toJsonList(String jsonString) throws JsonException {
		return instance.toJsonList(jsonString);
	}

	@Override
	public Map<String, Object> toJsonMap(String jsonString) throws JsonException {
		return instance.toJsonMap(jsonString);
	}

	@Override
	public Object toJson(byte[] jsonBytes) throws JsonException {
		return instance.toJson(jsonBytes);
	}

	@Override
	public List<Map<String, Object>> toJsonList(byte[] jsonBytes) throws JsonException {
		return instance.toJsonList(jsonBytes);
	}

	@Override
	public Map<String, Object> toJsonMap(byte[] jsonBytes) throws JsonException {
		return instance.toJsonMap(jsonBytes);
	}

	@Override
	public <T> T toObject(String jsonString, Class<T> clazz) throws JsonException {
		return instance.toObject(jsonString, clazz);
	}

	@Override
	public <T> T toObject(Object j, Class<T> clazz) throws JsonException {
		return instance.toObject(j, clazz);
	}

	@Override
	public <T> T toObject(byte[] jsonBytes, Class<T> clazz) throws JsonException {
		return instance.toObject(jsonBytes, clazz);
	}

	@Override
	public <T> T toObject(String jsonString, TypeReference<T> typeRef) throws JsonException {
		return instance.toObject(jsonString, typeRef);
	}

	@Override
	public <T> T toObject(byte[] jsonBytes, TypeReference<T> typeRef) throws JsonException {
		return instance.toObject(jsonBytes, typeRef);
	}

	@Override
	public <T> T toObject(Object json, TypeReference<T> typeRef) throws JsonException {
		return instance.toObject(json, typeRef);
	}

	@Override
	public <T> List<T> toObjectList(String jsonString, Class<T> clazz) throws JsonException {
		return instance.toObjectList(jsonString, clazz);
	}

	@Override
	public <T> List<T> toObjectList(byte[] jsonBytes, Class<T> clazz) throws JsonException {
		return instance.toObjectList(jsonBytes, clazz);
	}

	public String toJsonString(Object j) throws JsonException {
		return instance.toJsonString(j);
	}

	@Override
	public boolean validate(String jsonString) {
		return instance.validate(jsonString);
	}

}