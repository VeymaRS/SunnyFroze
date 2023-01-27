package com.weymar87.utils;

import com.weymar87.climate.Climate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.GregorianCalendar;

public class ClimateBaseCreate {

    //    public static void writeJson(String json) {
//        try (FileWriter file = new FileWriter("SoilBase.json")) {
//            file.write(json);
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private ObservableList<Climate> climateData = FXCollections.observableArrayList();

    public ClimateBaseCreate() {
        climateData.add(new Climate());
        climateData.add(new Climate());
        climateData.add(new Climate());
        climateData.get(0).setStartDate(new GregorianCalendar(2021, 5, 15));
        climateData.get(0).setLamdaSnow(0.2);
        climateData.get(0).addTemp(5,5,5,5,5,
                5,5,5,5,5,5,5);
        climateData.get(1).addTemp(2,2,2,2,2,
                2,2,2,2,2,2,2);
        climateData.get(2).addTemp(4,4,4,4,4,
                4,4,4,4,4,4,4);
//        climateData.get(0).calcAlphaWithSnow();
//        Gson gson = new Gson();
//        gson = new GsonBuilder()
//                .registerTypeAdapter(Soil.class, new SoilSerializer())
//                .registerTypeAdapter(SoilBase.class, new SoilBaseSerializer())
//                .create();
//        String json = gson.toJson(soilBase);
//
//        writeJson(json);
//
//        gson = new GsonBuilder()
//                .registerTypeAdapter(Soil.class, new SoilDeserialize())
//                .registerTypeAdapter(SoilBase.class, new SoilBaseDeserialize())
//                .create();
//        SoilBase soilBaseBack = gson.fromJson(json, SoilBase.class);
//
//        gson = new GsonBuilder()
//                .setPrettyPrinting()
//                .create();
//        System.out.println(gson.toJson(soilBaseBack));


    }

    public ObservableList<Climate> getClimateData() {
        return climateData;
    }
}
