package com.mercadolibre.json_jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import net.sf.json.JSONNull;

/**
 * @author mlabarinas
 */
public class JSONNullSerializer extends JsonSerializer<JSONNull> {
 
	public void serialize(JSONNull jsonNull, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNull();
    }
	
}