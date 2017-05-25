package com.mercadolibre.json_jackson;

import java.io.IOException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import com.fasterxml.jackson.databind.JavaType;
import com.mercadolibre.json.type.TypeReference;
import com.mercadolibre.json_jackson.type.JacksonTypeReference;
import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.util.ISO8601Utils;
import com.mercadolibre.json.Json;
import com.mercadolibre.json.exception.JsonException;

import net.sf.json.JSONNull;

/**
 * @author mlabarinas
 */
public class JsonJackson implements Json {
    private static final com.fasterxml.jackson.core.type.TypeReference<Map<String, Object>> MAP_TYPE_REFERENCE = new com.fasterxml.jackson.core.type.TypeReference<Map<String,Object>>() {};
    private static final com.fasterxml.jackson.core.type.TypeReference<List<Map<String, Object>>> MAP_LIST_TYPE_REFERENCE = new com.fasterxml.jackson.core.type.TypeReference<List<Map<String,Object>>>() {};

	private ObjectMapper mapper;

    public JsonJackson() {
    	this.mapper = getDefaultMapper();
    }
    
	public Object getEngine() {
		return this;
	}

    public Object toJson(String jsonString) throws JsonException {
        if (StringUtils.isBlank(jsonString)) return null;

        try {
            return mapper.readValue(jsonString, Object.class);
        } catch (IOException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

    public Object toJson(byte[] jsonBytes) throws JsonException {
        try {
            return mapper.readValue(jsonBytes, Object.class);
        } catch (IOException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

    public List<Map<String, Object>> toJsonList(String jsonString) throws JsonException {
        if (StringUtils.isBlank(jsonString)) return null;

        try {
            return mapper.readValue(jsonString, MAP_LIST_TYPE_REFERENCE);
        } catch (IOException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

    public List<Map<String, Object>> toJsonList(byte[] jsonBytes) throws JsonException {
        try {
            return mapper.readValue(jsonBytes, MAP_LIST_TYPE_REFERENCE);
        } catch (IOException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

    public Map<String, Object> toJsonMap(String jsonString) throws JsonException {
        if (StringUtils.isBlank(jsonString)) return null;

        try {
            return mapper.readValue(jsonString, MAP_TYPE_REFERENCE);
        } catch (IOException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

    public Map<String, Object> toJsonMap(byte[] jsonBytes) throws JsonException {
        try {
            return mapper.readValue(jsonBytes, MAP_TYPE_REFERENCE);
        } catch (IOException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

    public <T> T toObject(String jsonString, Class<T> clazz) throws JsonException {
        if (StringUtils.isBlank(jsonString)) return null;

        try {
            return mapper.readValue(jsonString, clazz);

        } catch (IOException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

    public <T> T toObject(byte[] jsonBytes, Class<T> clazz) throws JsonException {
        try {
            return mapper.readValue(jsonBytes, clazz);

        } catch (IOException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

    public <T> T toObject(String jsonString, TypeReference<T> typeRef) throws JsonException {
        if (StringUtils.isBlank(jsonString)) return null;

        try {
            return mapper.readValue(jsonString, new JacksonTypeReference<>(typeRef));

        } catch (IOException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

    public <T> T toObject(byte[] jsonBytes, TypeReference<T> typeRef) throws JsonException {
        try {
            return mapper.readValue(jsonBytes, new JacksonTypeReference<>(typeRef));

        } catch (IOException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }
    public <T> T toObject(String jsonString, JavaType typeRef) throws JsonException {
        if (StringUtils.isBlank(jsonString)) return null;

        try {
            return mapper.readValue(jsonString, typeRef);

        } catch (IOException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

    public <T> T toObject(byte[] jsonBytes, JavaType typeRef) throws JsonException {
        try {
            return mapper.readValue(jsonBytes, typeRef);

        } catch (IOException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

    public <T> T toObject(Object json, Class<T> clazz) throws JsonException {
        if (json == null) return null;

        try {
            return mapper.convertValue(json, clazz);

        } catch (IllegalArgumentException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

    public <T> T toObject(Object json, TypeReference<T> typeRef) throws JsonException {
        if (json == null) return null;

        try {
            return mapper.convertValue(json, new JacksonTypeReference<>(typeRef));

        } catch (IllegalArgumentException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

    public <T> T toObject(Object json, JavaType typeRef) throws JsonException {
        if (json == null) return null;

        try {
            return mapper.convertValue(json, typeRef);

        } catch (IllegalArgumentException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

    public <T> List<T> toObjectList(String jsonString, Class<T> clazz) throws JsonException {
        if (StringUtils.isBlank(jsonString)) return null;

        try {
            return mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(List.class, clazz));

        } catch (IOException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

    public <T> List<T> toObjectList(byte[] jsonBytes, Class<T> clazz) throws JsonException {
        try {
            return mapper.readValue(jsonBytes, mapper.getTypeFactory().constructCollectionType(List.class, clazz));

        } catch (IOException e) {
            throw new JsonException("Unexpected exception parsing json string", e);
        }
    }

	public String toJsonString(Object json) throws JsonException {
    	if (json instanceof String) {
    		if (validate((String) json))
    			return (String) json;
    		else
    			throw new JsonException("Unexpected exception parsing object to string");
    	}

    	try {
            return this.mapper.writeValueAsString(json);
        } catch (JsonProcessingException e) {
    	    throw new JsonException(e);
        }
	}

	public boolean validate(String jsonString) {
		try {
            JsonNode jsonNode = mapper.readTree(jsonString);
            
            return jsonNode.isObject() || jsonNode.isArray();
        } catch (IOException e) {
            return false;
        }
	}
	
	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}

    public ObjectMapper getMapper() {
        return mapper;
    }

    public ObjectMapper getDefaultMapper() {
		ObjectMapper mapper = new ObjectMapper();
        
        SimpleModule dateModule = new SimpleModule("dateSimpleModule", new Version(1,0,0,"1.0.0",null,null));

        dateModule.addSerializer(Date.class, new JsonSerializer<Date>() {
            @Override
            public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
                String date = ISO8601Utils.format(value, false, TimeZone.getTimeZone("GMT"));
                jgen.writeString(date);
            }
        });

        dateModule.addDeserializer(Date.class, new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
                try {
                    return ISO8601Utils.parse(jp.getText(), new ParsePosition(0));
                } catch (ParseException e) {
                    throw new IOException(e);
                }
            }
        });

        mapper.registerModule(new SimpleModule().addSerializer(JSONNull.class, new JSONNullSerializer()));
        mapper.registerModule(dateModule);

        mapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        
        return mapper;
	}
	
}