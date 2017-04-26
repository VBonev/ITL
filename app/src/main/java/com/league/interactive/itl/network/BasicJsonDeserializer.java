package com.league.interactive.itl.network;


import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

abstract class BasicJsonDeserializer<T> implements JsonDeserializer<List<T>> {

    @Override
    public List<T> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
            JsonParseException {
        Type type = ((ParameterizedType) typeOfT).getActualTypeArguments()[0];
        ElementKey elementKey = ((Class<T>) type).getAnnotation(ElementKey.class);

        if (elementKey != null) {
            String key = elementKey.value();
            if (key !=null && ! key.equals("") && json.isJsonObject()) {
                JsonElement elementForKey = json.getAsJsonObject().get(key);
                return manualDeserialize(elementForKey, context, type);
            } else {
                return manualDeserialize(json, context, type);
            }
        }

        return Collections.emptyList();
    }

    private List<T> manualDeserialize(JsonElement elementForKey, JsonDeserializationContext context, Type type) {
        List<T> list = new LinkedList<>();

        if (elementForKey.isJsonArray()) {
            JsonArray array = elementForKey.getAsJsonArray();
            int size = array.size();
            for (int i = 0; i < size; i++) {
                list.add(context.<T>deserialize(array.get(i), type));
            }
        }

        return list;
    }
}