package com.mercadolibre.json.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypeReference<T> implements Comparable<TypeReference<T>> {

    protected final Type type;

    protected TypeReference() {
        Type superClass = this.getClass().getGenericSuperclass();
        if (superClass instanceof Class)
            throw new IllegalArgumentException("TypeReference constructed without actual type information");
        else
            this.type = ((ParameterizedType)superClass).getActualTypeArguments()[0];
    }

    public Type getType() {
        return this.type;
    }

    public int compareTo(TypeReference<T> o) {
        return 0;
    }


}
