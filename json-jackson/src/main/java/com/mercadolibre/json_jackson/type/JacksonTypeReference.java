package com.mercadolibre.json_jackson.type;

import com.fasterxml.jackson.core.type.TypeReference;

import java.lang.reflect.Type;

public class JacksonTypeReference<T> extends TypeReference<T> {

    private final com.mercadolibre.json.type.TypeReference<T> reference;

    public JacksonTypeReference(com.mercadolibre.json.type.TypeReference<T> reference) {
        this.reference = reference;
    }

    @Override
    public Type getType() {
        return reference.getType();
    }

}
