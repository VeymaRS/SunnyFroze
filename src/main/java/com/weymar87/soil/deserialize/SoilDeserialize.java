package com.weymar87.soil.deserialize;

import com.google.gson.*;
import com.weymar87.soil.Soil;

import java.lang.reflect.Type;

public class SoilDeserialize implements JsonDeserializer<Soil> {
    @Override
    public Soil deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        Soil soil = new Soil();
        soil.setNameSoil(jsonObject.get("nameSoil").getAsString());
        soil.setTypeSoil(jsonObject.get("typeSoil").getAsString());
        soil.setLp(jsonObject.get("Lp").getAsDouble());
        soil.setWtot(jsonObject.get("Wtot").getAsDouble());
        soil.setRod(jsonObject.get("rod").getAsDouble());
        soil.setWp(jsonObject.get("Wp").getAsDouble());
        soil.setWm(jsonObject.get("Wm").getAsDouble());
        soil.setTbf(jsonObject.get("Tbf").getAsDouble());
        soil.setLambda_th(jsonObject.get("lamda_th").getAsDouble());
        soil.setLamda_f(jsonObject.get("lamda_f").getAsDouble());
        soil.setCth(jsonObject.get("cth").getAsDouble());
        soil.setCf(jsonObject.get("cf").getAsDouble());
        soil.setDsal(jsonObject.get("Dsal").getAsDouble());
        soil.setItot(jsonObject.get("itot").getAsDouble());
        soil.setJ(jsonObject.get("j").getAsDouble());
        soil.setJ(jsonObject.get("soilWidth").getAsDouble());

        return soil;
    }
}
