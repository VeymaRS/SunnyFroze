package com.weymar87;

public class Main {

    //    public static void writeJson(String json) {
//        try (FileWriter file = new FileWriter("SoilBase.json")) {
//            file.write(json);
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public static void start() {

//        Climate com.weymar87.climate = new Climate(-16.0, -15.0, -5.0, 0.0, 5.0, 10.0, 17.0,
//                15.0, 10.0, -2.0, -5.0, -15.0);
//
//
//
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

//        Neyavnaya_2D neyavnaya_2D = new Neyavnaya_2D();
//        Mash mash = new Mash();
//        mash.createSoilMash();
//        mash.createArrTempOnTheMash();
//        SoilBase soilBase = SoilBaseCreate.createBase();
//        mash.putSoilsOnTheMash(soilBase);
//        mash.putTempOnTheMash(new double[][]{{0, -0.5, -1, -1.5, -2, -2.5, -3, -3.5, -4, -4.5, -5, -6, -7, -8, -9, -10,
//                -12, -14},
//                {-20, -18, -16, -14, -12, -10, -8, -7, -2, -2, -2, -2, -2, -2, -2.3, -2.2, -2.5, -2.7}});
//        mash.set_C_min(soilBase);
//        mash.set_Lamd_max(soilBase);
//        Climate climate = ClimateCreate.climateCreate();

//        neyavnaya_2D.calculate_neyavnaya_2D(86400 * 30, mash, climate, 86400);
//        neyavnaya_2D.printResultAtDot(2, 95, "dot.csv");
//        neyavnaya_2D.printResultLine(99, 30);
//        neyavnaya_2D.printResult(30);


//        neyavnaya_2D.saveToCSV("result.csv", com.weymar87.mash);
    }
}