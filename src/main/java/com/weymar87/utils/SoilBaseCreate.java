package com.weymar87.utils;

import com.weymar87.solver.CalculateLinearInt;
import com.weymar87.soil.Soil;
import com.weymar87.soil.SoilBase;

public class SoilBaseCreate {
    public static SoilBase createBase() {
        SoilBase soilBase = new SoilBase();

        Soil soil;

        CalculateLinearInt calculateLinearInt = new CalculateLinearInt();

        //слои задаются в порядке сверху вниз по расчетной области

//        soil = new Soil("IGE1", "SAND", 0.00, 0.2, 1600, 0.0,
//                0.2, -0.1, 1.8, 2, 2.4E6, 2.2E6, 0.0, 0.2, 0.0, 2);
//        soilBase.addSoil(soil);
//        calculateLinearInt.calculate_Ww_by_SP_arr(soil);
//
//        soil = new Soil("IGE2", "SILT", 0.04, 0.25, 1500, 0.2,
//                0.2, -0.15, 1.6, 1.8, 2.2E6, 2E6, 0.0, 0.2, 0.0, 2);
//        soilBase.addSoil(soil);
//        calculateLinearInt.calculate_Ww_by_SP_arr(soil);
//
//        soil = new Soil("IGE3", "LEANCLAY", 0.08, 0.3, 1300, 0.2,
//                0.2, -0.20, 1.3, 1.5, 2.0E6, 1.8E6, 0.0, 0.2, 0.0, 6);
//        soilBase.addSoil(soil);
//        calculateLinearInt.calculate_Ww_by_SP_arr(soil);

        return soilBase;
    }


}
