package com.weymar87.soil.serialize;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.weymar87.soil.Soil;
import com.weymar87.soil.SoilBase;

import java.lang.reflect.Type;

public class SoilBaseSerializer implements JsonSerializer<SoilBase> {
    @Override
    public JsonElement serialize(SoilBase src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        for (Soil soil : src.getSoilList())
        {
            result.add(soil.getNameSoil(), context.serialize(soil));
        }
        return result;
    }
}
