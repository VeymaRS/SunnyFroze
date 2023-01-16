package com.weymar87.soil.deserialize;

import com.google.gson.*;
import com.weymar87.soil.Soil;
import com.weymar87.soil.SoilBase;

import java.lang.reflect.Type;
import java.util.Map;

public class SoilBaseDeserialize implements JsonDeserializer<SoilBase> {
    @Override
    public SoilBase deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        SoilBase result = new SoilBase();

        JsonObject jsonObject = json.getAsJsonObject();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            Soil soil = context.deserialize(entry.getValue(), Soil.class);
            soil.setNameSoil(entry.getKey());
            result.addSoil(soil);
        }

        return result;
    }
}
