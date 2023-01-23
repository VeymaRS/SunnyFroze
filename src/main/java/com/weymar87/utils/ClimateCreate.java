package com.weymar87.utils;

import com.weymar87.climate.Climate;
import com.weymar87.soil.SoilBase;

import java.util.GregorianCalendar;

public class ClimateCreate {

    public static Climate climateCreate() {
        Climate climate = new Climate();

        climate.addTemp(
                -21.6,
                -21.9,
                -17.3,
                -12.8,
                -5.2,
                2.3,
                7.3,
                7.2,
                3.8,
                -4.2,
                -12.7,
                -17.9
        );

//        climate.addWind(
//                6.5,
//                6.4,
//                6.5,
//                6.3,
//                6.2,
//                5.6,
//                5.3,
//                5.4,
//                6.0,
//                6.9,
//                6.8,
//                6.8
//        );
//
//        climate.addSnow(
//                0.1367,
//                0.14,
//                0.1667,
//                0.1767,
//                0.16,
//                0,
//                0,
//                0,
//                0,
//                0.055,
//                0.09,
//                0.12
//        );
        climate.setStartDate(new GregorianCalendar(2021, 5, 15));
        climate.setLamdaSnow(0.2);
        climate.calcAlphaWithSnow();

        return climate;
    }

}
