package com.weymar87.solver;

import com.weymar87.soil.Soil;

public class CalculateLinearInt {
    private double L = 334000;
    private int type_kW = 8;
    private int type_Eta = 0;

    public double getL() {
        return L;
    }

    public CalculateLinearInt() {

    }

    public double nrt(double T) {
        double nrt;
        nrt = Math.pow(T, 1.0 / 4.0);
        return nrt;
    }

    private void setTypeOfSoilForCalculate(Soil soil) {
        if (soil.getTypeSoil().equals("SAND")) {
            type_kW = 1;
            type_Eta = 1;
        } else if (soil.getTypeSoil().equals("FINESAND")) {
            type_kW = 2;
            type_Eta = 1;
        } else if (soil.getTypeSoil().equals("SILT") & soil.getLp() <= 0.02) {
            type_kW = 3;
            type_Eta = 1;
        } else if (soil.getTypeSoil().equals("SILT") & soil.getLp() > 0.02 & soil.getLp() <= 0.07) {
            type_kW = 4;
            type_Eta = 2;
        } else if (soil.getTypeSoil().equals("LEANCLAY") & soil.getLp() > 0.07 & soil.getLp() <= 0.13) {
            type_kW = 5;
            type_Eta = 3;
        } else if (soil.getTypeSoil().equals("LEANCLAY") & soil.getLp() > 0.13 & soil.getLp() <= 0.17) {
            type_kW = 6;
            type_Eta = 4;
        } else if (soil.getTypeSoil().equals("FATCLAY") & soil.getLp() > 0.17) {
            type_kW = 7;
            type_Eta = 4;
        } else if (soil.getTypeSoil().equals("PEAT")) {
            type_kW = 8;
        }
    }

    private double[][] arr_kw = {
            {-0.3, -0.5, -1.0, -2.0, -3.0, -4.0, -6.0, -8.0, -10.0, -15.0},
            {0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00}, //1 тип песок (кроме пылеватых)
            {0.50, 0.35, 0.30, 0.25, 0.23, 0.22, 0.21, 0.20, 0.19, 0.18}, //2 тип песок пылеватый
            {0.50, 0.35, 0.30, 0.25, 0.23, 0.22, 0.21, 0.20, 0.19, 0.18}, //3 тип супеси Ip<=0.02
            {0.60, 0.50, 0.40, 0.35, 0.32, 0.30, 0.27, 0.26, 0.25, 0.23}, //4 тип супеси 0.02 < Ip <=0.07
            {0.70, 0.65, 0.58, 0.50, 0.46, 0.44, 0.42, 0.41, 0.40, 0.38}, //5 тип суглинки 0.07 < Ip <=0.13
            {0.80, 0.75, 0.65, 0.55, 0.51, 0.49, 0.47, 0.46, 0.45, 0.43}, //6 тип суглинки 0.13 < Ip <=0.17
            {0.98, 0.92, 0.80, 0.68, 0.63, 0.60, 0.57, 0.56, 0.55, 0.53}  //7 тип глины Ip > 0.17
    };

    private double[][] arr_Eta = {
            {-0.3, -0.5, -1.0, -2.0, -3.0, -4.0, -6.0, -8.0, -10.0, -15.0},
            {210.00, 160.00, 75.00, 34.00, 20.00, 14.00, 9.00, 6.50, 5.00, 4.00}, //1 тип супеси Ip<=0.02
            {150.00, 130.00, 57.00, 24.00, 15.00, 11.00, 7.00, 5.00, 4.50, 3.50}, //2 тип супеси 0.02 < Ip <=0.07
            {130.00, 103.00, 44.00, 19.00, 11.00, 8.00, 5.50, 4.00, 3.20, 2.30}, //3 тип суглинки 0.07 < Ip <=0.13
            {102.00, 70.00, 34.00, 17.00, 9.50, 6.50, 4.00, 3.00, 2.50, 2.00} //4 тип суглинки, глины Ip > 0.13
    };

    public double interpolation(double[][] arr, double T) {
        double result = 0;
        if (T > arr[0][arr[0].length - 1] & T < arr[0][0]) {
            for (int i = 0; i < arr[0].length; i++) {
                if (T <= arr[0][i] & T >= arr[0][i + 1]) {
                    double x2 = arr[0][i + 1];
                    double x1 = arr[0][i];
                    double y2 = arr[1][i + 1];
                    double y1 = arr[1][i];
                    double alpha = (y2 - y1) / (x2 - x1);
                    double beta = y1 - alpha * x1;
                    result = alpha * T + beta;
                    break;
                }
            }
        } else if (T == arr[0][0]) {
            result = arr[1][0];
        } else if (T <= arr[0][arr[0].length - 1]) {
            result = arr[1][arr[0].length - 1];
        }
        return result;
    }

//    public double lagrangePolynomialWw(double[][] arrWwSoil, double T) {
//        int n = 11;
//
//        double y = 0;
//        double numerator;
//        if (T > arrWwSoil[0][arrWwSoil[0].length - 1] & T <= arrWwSoil[0][0]) {
//            for (int i = 0; i < n; i++) {
//                numerator = 1;
//                for (int j = 0; j < n; j++) {
//                    if (j != i) {
//                        numerator *= (T - arrWwSoil[0][j]) / (arrWwSoil[0][i] - arrWwSoil[0][j]);
//                    }
//                }
//                y += numerator * arrWwSoil[1][i];
//            }
//        } else if (T <= arrWwSoil[0][arrWwSoil[0].length - 1]) {
//            y = arrWwSoil[1][arrWwSoil[0].length - 1];
//        }
//
//        return y;
//    }


    public void calculate_Ww_by_SP_arr(Soil soil) {
        setTypeOfSoilForCalculate(soil);
        soil.getArrWwSoil()[0][0] = soil.getTbf();
        soil.getArrWwSoil()[1][0] = soil.getWtot();

        if (soil.getTypeSoil().equals("PEAT")) { //для торфа
//                if (com.weymar87.soil.getTypePeatNumber() == 1) {
            for (int i = 1; i <= arr_kw.length + 2; i++) {
                soil.getArrWwSoil()[0][i] = arr_kw[0][i - 1];
                soil.getArrWwSoil()[1][i] = 1.6 / nrt(Math.abs(arr_kw[0][i - 1]));
//                } else if (com.weymar87.soil.getTypePeatNumber() == 2) {
//                    Ww = (1.6 * com.weymar87.soil.getJ() - 0.1) / v;
//                } else if (com.weymar87.soil.getTypePeatNumber() == 3) {
//                    Ww = (1.6 * com.weymar87.soil.getJ()) / v;
//                }
            }
        } else if (soil.getTypeSoil().equals("SAND")) {
            soil.getArrWwSoil()[0][0] = soil.getTbf();
            soil.getArrWwSoil()[1][0] = soil.getWtot();
            soil.getArrWwSoil()[0][1] = soil.getTbf() - 15;
            soil.getArrWwSoil()[1][1] = 0;


        } else {
            for (int i = 1; i <= arr_kw.length + 2; i++) {
                soil.getArrWwSoil()[0][i] = arr_kw[0][i - 1];
                soil.getArrWwSoil()[1][i] = arr_kw[type_kW][i - 1] * soil.getWp() +
                        arr_Eta[type_Eta][i - 1] * soil.getDsal() / 100;
            }
        }

    }


    public double getWwFromArr(double T, Soil soil) {
        double Ww = 0;
        if (T <= soil.getTbf()) {
            if (soil.getTypeSoil().equals("SAND")) {
//                Ww = com.weymar87.soil.getWtot() / (1 + 100 * (com.weymar87.soil.getTbf() - T));
                Ww = 0;
            } else {
                Ww = interpolation(soil.getArrWwSoil(), T);
                if (Ww > soil.getWtot()) {
                    Ww = soil.getWtot();
                }
//                        } else if (T >= com.weymar87.soil.getTbf() & T < 0 & com.weymar87.soil.getItot() <= 0.4) {
//            Ww = com.weymar87.soil.getWtot();
//        } else if (T >= com.weymar87.soil.getTbf() & T < 0 & com.weymar87.soil.getItot() > 0.4) {
//            Ww = com.weymar87.soil.getWm();
            }
        } else if (T > soil.getTbf()) {
            Ww = soil.getWtot();
        }
        return Ww;
    }

    public double calculate_C(double T, Soil soil, double e) {
        double c_eff = 0;
        double Ww = getWwFromArr(T, soil);
        double c = soil.getCf() * (1 - Ww / soil.getWtot()) +
                soil.getCth() * Ww / soil.getWtot();

        if (T <= soil.getTbf() - e) {
            c_eff = c + soil.getRod() * L * Ww;
        } else if (T > soil.getTbf() - e & T < soil.getTbf() + e) {
            c_eff = (c + soil.getRod() * L * Ww + ((T - soil.getTbf() + e) / 2 * e) * (soil.getCth() -
                    (c + soil.getRod() * L * Ww)));
        } else if (T >= soil.getTbf() + e) {
            c_eff = c;
        }
        return c_eff;
    }

    public double calculate_lambda(double T, Soil soil, double e) {
        double lamda_eff = soil.getLamda_f() * (1 - getWwFromArr(T, soil) / soil.getWtot()) + soil.getLambda_th() *
                (getWwFromArr(T, soil) / soil.getWtot());
        double lamda = 0;
        if (T <= soil.getTbf() - e) {
            lamda = lamda_eff;
        } else if (T > soil.getTbf() - e & T < soil.getTbf() + e) {
            lamda = lamda_eff + ((T - soil.getTbf() + e) / 2 * e) * (soil.getLambda_th() - lamda_eff);
        } else if (T >= soil.getTbf() + e) {
            lamda = lamda_eff;
        }
        return lamda;
    }

    public double calculate_Ro_L(double T, Soil soil, double e) {
        double ro_l = 0;
        if (T > soil.getTbf() - e & T < soil.getTbf() + e) {
            ro_l = (soil.getRod() * L * (soil.getWtot() - getWwFromArr(soil.getTbf() - e, soil))) * 0.5 / e;
        }
        return ro_l;
    }

    public int getType_kW() {
        return type_kW;
    }

    public int getType_Eta() {
        return type_Eta;
    }
}