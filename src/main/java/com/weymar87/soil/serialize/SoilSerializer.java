package com.weymar87.soil.serialize;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.weymar87.soil.Soil;

import java.lang.reflect.Type;

public class SoilSerializer implements JsonSerializer<Soil> {
    @Override
    public JsonElement serialize(Soil src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.addProperty("nameSoil", src.getNameSoil());
        result.addProperty("typeSoil", src.getTypeSoil());
        result.addProperty("Lp", src.getLp());
        result.addProperty("Wtot", src.getLp());
        result.addProperty("rod", src.getRod());
        result.addProperty("Wp", src.getWp());
        result.addProperty("Wm", src.getWm());
        result.addProperty("Tbf", src.getTbf());
        result.addProperty("lamda_th", src.getLambda_th());
        result.addProperty("lamda_f", src.getLamda_f());
        result.addProperty("cth", src.getCth());
        result.addProperty("cf", src.getCf());
        result.addProperty("Dsal", src.getDsal());
        result.addProperty("itot", src.getItot());
        result.addProperty("j", src.getJ());
        result.addProperty("soilWidth", src.getSoilWidth());

        return result;
    }
}
