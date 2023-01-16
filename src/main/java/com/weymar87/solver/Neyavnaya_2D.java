package com.weymar87.solver;

import com.weymar87.climate.Climate;
//import com.opencsv.CSVWriter;
import com.weymar87.mash.Mash;
import com.weymar87.soil.Soil;


import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class Neyavnaya_2D {

    public static boolean isEqual(double max, double eps) {
        return max > eps;
    }

    public static void calc_GU3(Soil soil) {

    }

    double[][] arrT;
    double[][] arrTnX;
    double[][] arrTnY;
    double[][] arrTs;
    double[][] arrTprint;
    Map<Integer, double[][]> arrTmemory;

    double[] arrAlphaX;
    double[] arrBetaX;

    double[] arrAlphaY;
    double[] arrBetaY;

    double ai;
    double bi;
    double ci;
    double fi;
    double alphaX;
    double alphaY;
    double tau;
    double Te;
    double kappa;
//    double T0 = 5;
    double d1;

    double e = 1E-5;
    double delta = 0.04;
    double max1;
    double max2;


    double time;
    double end;
    Integer c = 1;

    public void calculate_neyavnaya_2D(double endtimeT, Mash mash, Climate climate, int printIterStep) {//, Climate com.weymar87.climate) {
        end = endtimeT;
        CalculateLinearInt cal = new CalculateLinearInt();
        arrTmemory = new HashMap<>();

        arrT = new double[mash.getNx()][mash.getNy()];
        arrTnX = new double[mash.getNx()][mash.getNy()];
        arrTnY = new double[mash.getNx()][mash.getNy()];
        arrTs = new double[mash.getNx()][mash.getNy()];
        arrAlphaX = new double[mash.getNx()];
        arrBetaX = new double[mash.getNx()];
        arrAlphaY = new double[mash.getNy()];
        arrBetaY = new double[mash.getNy()];

        tau = mash.getC_min() / 2 * 2 * mash.getLamda_max() * Math.pow(mash.get_h_min(), 2);


//        for (int i = 0; i < com.weymar87.mash.getNx(); i++) {
//            for (int j = 0; j < com.weymar87.mash.getNy(); j++)
//                arrT[i][j] = T0;
//        }

        arrT = mash.getArrTempOnTheMash();

        arrTprint = new double[mash.getNx()][mash.getNy()];
        for (int i = 0; i < mash.getNx(); i++) {
            for (int j = 0; j < mash.getNy(); j++) {
                arrTprint[i][j] = arrT[i][j];
            }
        }
        arrTmemory.put(c, arrTprint);
        c += 1;

        time = 0;

        if (tau > 3600) {
            tau = 3600;
        }


        while (time < endtimeT) {

            time += tau;
            Te = climate.interpolationForClimate(time, 0.04, 1);
            kappa = climate.interpolationForClimate(time,0.04, 4);

            for (int i = 0; i < mash.getNx(); i++) {
                for (int j = 0; j < mash.getNy(); j++)
                    arrTnX[i][j] = arrT[i][j];
            }


            if (time / printIterStep >= c) {
                arrTprint = new double[mash.getNx()][mash.getNy()];
                for (int i = 0; i < mash.getNx(); i++) {
                    for (int j = 0; j < mash.getNy(); j++) {
                        arrTprint[i][j] = arrT[i][j];
                    }
                }
                arrTmemory.put(c, arrTprint);
                c += 1;
            }

            //прогнонка вдоль оси X;
            for (int j = 0; j < mash.getNy(); j++) {
                do {
                    for (int n = 0; n < mash.getNx(); n++) {
                        for (int m = 0; m < mash.getNy(); m++)
                            arrTs[n][m] = arrT[n][m];
                    }

//                    if(com.weymar87.mash.getArrGUonTheMash()[0][j]==1) {
//                    arrAlphaX[0] = 0.0;
//                    arrBetaX[0] = Tl;
//                    }

                    Soil soilLeft = mash.getSoil(0, j);
                    alphaX = cal.calculate_lambda(arrTnX[0][j], soilLeft, delta) /
                            (cal.calculate_C(arrTnX[0][j], soilLeft, delta))
                            + cal.calculate_Ro_L(arrTnX[0][j], soilLeft, delta);

                    double v1 = 2 * alphaX * tau + Math.pow(mash.getHx(), 2);
                    arrAlphaX[0] = 2 * alphaX * tau / v1;
                    arrBetaX[0] = (Math.pow(mash.getHx(), 2) * arrTnX[0][j]) / v1;


                    for (int i = 1; i < mash.getNx() - 1; i++) {
                        Soil soil = mash.getSoil(i, j);
                        if (soil.getNameSoil().equals(mash.getSoil(i - 1, j).getNameSoil())) {
                            ai = 0.5 * (cal.calculate_lambda(arrTnX[i][j], soil, delta) + cal.calculate_lambda(arrTnX[i + 1][j], soil, delta))
                                    / Math.pow(mash.getHx(), 2);
                            ci = 0.5 * (cal.calculate_lambda(arrTnX[i - 1][j], soil, delta) + cal.calculate_lambda(arrTnX[i][j], soil, delta))
                                    / Math.pow(mash.getHx(), 2);
                            bi = ai + ci + (cal.calculate_C(arrTnX[i][j], soil, delta) + cal.calculate_Ro_L(arrTnX[i][j], soil, delta)) / tau;
                            fi = -(cal.calculate_C(arrTnX[i][j], soil, delta) + cal.calculate_Ro_L(arrTnX[i][j], soil, delta)) * arrTnX[i][j] / tau;
                            double v2 = bi - ci * arrAlphaX[i - 1];
                            arrAlphaX[i] = ai / v2;
                            arrBetaX[i] = (ci * arrBetaX[i - 1] - fi) / v2;
                        } else if (soil.getNameSoil() != mash.getSoil(i - 1, j).getNameSoil()) {
                            Soil soil1 = mash.getSoil(i - 1, j);
                            Soil soil2 = mash.getSoil(i, j);
                            double alpha1 = cal.calculate_lambda(arrTnX[i - 1][j], soil1, delta) /
                                    (cal.calculate_C(arrTnX[i - 1][j], soil1, delta) + cal.calculate_Ro_L(arrTnX[i - 1][j], soil1, delta));
                            double alpha2 = cal.calculate_lambda(arrTnX[i][j], soil2, delta) /
                                    (cal.calculate_C(arrTnX[i][j], soil2, delta) + cal.calculate_Ro_L(arrTnX[i][j], soil2, delta));
                            double v3 = (2.0 * alpha1 * alpha2 * tau * (cal.calculate_lambda(arrTnX[i][j], soil2, delta) +
                                    cal.calculate_lambda(arrTnX[i - 1][j], soil1, delta) * (1 - arrAlphaX[i - 1]))
                                    + Math.pow(mash.getHx(), 2) * (alpha1 * cal.calculate_lambda(arrTnX[i][j], soil2, delta)
                                    + alpha2 * cal.calculate_lambda(arrTnX[i - 1][j], soil1, delta)));

                            arrAlphaX[i] = 2.0 * alpha1 * alpha2 * tau * cal.calculate_lambda(arrTnX[i][j], soil2, delta) / v3;

                            arrBetaX[i] = (2.0 * alpha1 * alpha2 * tau * cal.calculate_lambda(arrTnX[i - 1][j], soil1, delta) *
                                    arrBetaX[i - 1] + Math.pow(mash.getHx(), 2) * (alpha1 * cal.calculate_lambda(arrTnX[i][j], soil2, delta)
                                    + alpha2 * cal.calculate_lambda(arrTnX[i - 1][j], soil1, delta)) * arrTnX[i][j]) / v3;
                        }
                    }
//                    arrT[com.weymar87.mash.getNx() - 1][j] = Tr;

                    Soil soilRight = mash.getSoil(mash.getNx() - 1, j);
                    alphaX = cal.calculate_lambda(arrTnX[mash.getNx() - 1][j], soilRight, delta) /
                            (cal.calculate_C(arrTnX[mash.getNx() - 1][j], soilRight, delta) +
                                    cal.calculate_Ro_L(arrTnX[mash.getNx() - 1][j], soilRight, delta));

                    arrT[mash.getNx() - 1][j] = (2.0 * alphaX * tau *
                            cal.calculate_lambda(arrTnX[mash.getNx() - 1][j], soilRight, delta) * arrBetaX[mash.getNx() - 2]
                            + cal.calculate_lambda(arrTnX[mash.getNx() - 1][j], soilRight, delta) * Math.pow(mash.getHx(), 2)
                            * arrTnX[mash.getNx() - 1][j]) / (2.0 * alphaX *
                            cal.calculate_lambda(arrTnX[mash.getNx() - 1][j], soilRight, delta) * tau *
                            (1.0 - arrAlphaX[mash.getNx() - 2])
                            + Math.pow(mash.getHx(), 2) * cal.calculate_lambda(arrTnX[mash.getNx() - 1][j], soilRight, delta));


//
//                    arrT[com.weymar87.mash.getNx() - 1][j] = (2.0 * alphaX * tau * arrBetaX[com.weymar87.mash.getNx() - 2] + Math.pow(com.weymar87.mash.getHx(), 2)
//                            * arrTnX[com.weymar87.mash.getNx() - 1][j]) / (2.0 * alphaX * tau * (1.0 - arrAlphaX[com.weymar87.mash.getNx() - 2])
//                            + Math.pow(com.weymar87.mash.getHx(), 2));

                    for (int i = mash.getNx() - 2; i >= 0; i--) {
                        arrT[i][j] = arrAlphaX[i] * arrT[i + 1][j] + arrBetaX[i];
                    }

                    max1 = Math.abs(arrT[0][j] - arrTs[0][j]);
                    for (int i = 1; i < mash.getNx(); i++) {
                        if (max1 < Math.abs(arrT[i][j] - arrTs[i][j])) {
                            max1 = Math.abs(arrT[i][j] - arrTs[i][j]);
                        }
                    }

                    max2 = Math.abs(arrT[0][j]);
                    for (int i = 1; i < mash.getNx(); i++) {
                        if (max2 < Math.abs(arrT[i][j])) {
                            max2 = Math.abs(arrT[i][j]);
                        }
                    }

                }
                while (
                        isEqual(max1 / max2, e)
                );
            }

            for (int i = 0; i < mash.getNx(); i++) {
                for (int j = 0; j < mash.getNy(); j++)
                    arrTnY[i][j] = arrT[i][j];
            }

            //прогнонка вдоль оси Y;
            for (int i = 0; i < mash.getNx(); i++) {

                do {
                    for (int n = 0; n < mash.getNx(); n++) {
                        for (int m = 0; m < mash.getNy(); m++)
                            arrTs[n][m] = arrT[n][m];
                    }

                    for (int j = 1; j < mash.getNy() - 1; j++) {
//                        if (arrTnY[i][j] * arrTnY[i][j + 1] < 0) {
//                            delta = Math.abs(arrTnY[i][j + 1] - arrTnY[i][j - 1]);
//                        } else {
//                            delta = 0.001;
//                        }

                        Soil soilDown = mash.getSoil(i, 0);
                        alphaY = cal.calculate_lambda(arrTnY[i][0], soilDown, delta) /
                                (cal.calculate_C(arrTnY[i][0], soilDown, delta) + cal.calculate_Ro_L(arrTnY[i][0], soilDown, delta));

                        double v1 = 2 * alphaY * tau + Math.pow(mash.getHy(), 2);
                        arrAlphaY[0] = 2 * alphaY * tau / v1;
                        arrBetaY[0] = (Math.pow(mash.getHy(), 2) * arrTnY[i][0]) / v1;


                        Soil soil = mash.getSoil(i, j);
                        if (soil.getNameSoil().equals(mash.getSoil(i, j - 1).getNameSoil())) {
                            ai = 0.5 * (cal.calculate_lambda(arrTnY[i][j], soil, delta) + cal.calculate_lambda(arrTnY[i][j + 1], soil, delta))
                                    / Math.pow(mash.getHy(), 2);
                            ci = 0.5 * (cal.calculate_lambda(arrTnY[i][j - 1], soil, delta) + cal.calculate_lambda(arrTnY[i][j], soil, delta))
                                    / Math.pow(mash.getHy(), 2);
                            bi = ai + ci + (cal.calculate_C(arrTnY[i][j], soil, delta) + cal.calculate_Ro_L(arrTnY[i][j], soil, delta)) / tau;
                            fi = -(cal.calculate_C(arrTnY[i][j], soil, delta) + cal.calculate_Ro_L(arrTnY[i][j], soil, delta)) * arrTnY[i][j] / tau;

                            double v2 = bi - ci * arrAlphaY[j - 1];
                            arrAlphaY[j] = ai / v2;
                            arrBetaY[j] = (ci * arrBetaY[j - 1] - fi) / v2;

                        } else if (soil.getNameSoil() != mash.getSoil(i, j - 1).getNameSoil()) {
                            Soil soil1 = mash.getSoil(i, j - 1);
                            Soil soil2 = mash.getSoil(i, j);
                            double alpha1 = cal.calculate_lambda(arrTnY[i][j - 1], soil1, delta) /
                                    (cal.calculate_C(arrTnY[i][j - 1], soil1, delta) + cal.calculate_Ro_L(arrTnY[i][j - 1], soil1, delta));
                            double alpha2 = cal.calculate_lambda(arrTnY[i][j], soil2, delta) /
                                    (cal.calculate_C(arrTnY[i][j], soil2, delta) + cal.calculate_Ro_L(arrTnY[i][j], soil2, delta));

                            double v3 = (2.0 * alpha1 * alpha2 * tau * (cal.calculate_lambda(arrTnY[i][j], soil2, delta) +
                                    cal.calculate_lambda(arrTnY[i][j - 1], soil1, delta) * (1 - arrAlphaY[j - 1]))
                                    + Math.pow(mash.getHy(), 2) * (alpha1 * cal.calculate_lambda(arrTnY[i][j], soil2, delta)
                                    + alpha2 * cal.calculate_lambda(arrTnY[i][j - 1], soil1, delta)));

                            arrAlphaY[j] = 2.0 * alpha1 * alpha2 * tau * cal.calculate_lambda(arrTnY[i][j], soil2, delta) / v3;

                            arrBetaY[j] = (2.0 * alpha1 * alpha2 * tau * cal.calculate_lambda(arrTnY[i][j - 1], soil1, delta) *
                                    arrBetaY[j - 1] + Math.pow(mash.getHy(), 2) * (alpha1 * cal.calculate_lambda(arrTnY[i][j], soil2, delta)
                                    + alpha2 * cal.calculate_lambda(arrTnY[i][j - 1], soil1, delta)) * arrTnY[i][j]) / v3;
                        }
                    }

//                    arrT[i][com.weymar87.mash.getNy() - 1] = Tup;

                    Soil soilUp = mash.getSoil(i, mash.getNy() - 1);
                    alphaY = cal.calculate_lambda(arrTnY[i][mash.getNy() - 1], soilUp, delta) /
                            (cal.calculate_C(arrTnY[i][mash.getNy() - 1], soilUp, delta)
                                    + cal.calculate_Ro_L(arrTnY[i][mash.getNy() - 1], soilUp, delta));

                    do {
                        d1 = arrT[i][mash.getNy() - 1];
                        arrT[i][mash.getNy() - 1] = (cal.calculate_lambda(arrTnY[i][mash.getNy() - 1], soilUp, delta) *
                                Math.pow(mash.getHy(), 2) * arrTnY[i][mash.getNy() - 1] + (2.0 * alphaY * tau *
                                (cal.calculate_lambda(arrTnY[i][mash.getNy() - 1], soilUp, delta) *
                                        arrBetaY[mash.getNy() - 2] + mash.getHy() * Te * kappa))) /
                                (Math.pow(mash.getHy(), 2) *
                                        cal.calculate_lambda(arrTnY[i][mash.getNy() - 1], soilUp, delta) +
                                        2.0 * alphaY * tau * (mash.getHy() * kappa +
                                                cal.calculate_lambda(arrTnY[i][mash.getNy() - 1], soilUp, delta) *
                                                        (1.0 - arrAlphaY[mash.getNy() - 2])));

                    } while (
                            isEqual(Math.abs(d1 - arrT[i][mash.getNy() - 1]), e)
                    );
//                    arrT[i][com.weymar87.mash.getNy() - 1] = (cal.calculate_lambda(arrTnY[i][com.weymar87.mash.getNy() - 1], soilUp) *
//                            Math.pow(com.weymar87.mash.getHy(), 2) * arrTnY[i][com.weymar87.mash.getNy() - 1] + 2.0 *  )

//
//                    arrT[i][com.weymar87.mash.getNy() - 1] = (2.0 * alphaY * tau *
//                            cal.calculate_lambda(arrTnY[i][com.weymar87.mash.getNy() - 1], soilUp, delta) * arrBetaY[com.weymar87.mash.getNy() - 2]
//                            + cal.calculate_lambda(arrTnY[i][com.weymar87.mash.getNy() - 1], soilUp, delta) * Math.pow(com.weymar87.mash.getHy(), 2)
//                            * arrTnY[i][com.weymar87.mash.getNy() - 1]) / (2.0 * alphaY *
//                            cal.calculate_lambda(arrTnY[i][com.weymar87.mash.getNy() - 1], soilUp, delta) * tau *
//                            (1.0 - arrAlphaY[com.weymar87.mash.getNy() - 2])
//                            + Math.pow(com.weymar87.mash.getHy(), 2) * cal.calculate_lambda(arrTnY[i][com.weymar87.mash.getNy() - 1], soilUp, delta));

                    for (int j = mash.getNy() - 2; j >= 0; j--) {
                        arrT[i][j] = arrAlphaY[j] * arrT[i][j + 1] + arrBetaY[j];
                    }

                    max1 = Math.abs(arrT[i][0] - arrTs[i][0]);
                    for (int j = 1; j < mash.getNy() - 1; j++) {
                        if (max1 < Math.abs(arrT[i][j] - arrTs[i][j])) {
                            max1 = Math.abs(arrT[i][j] - arrTs[i][j]);
                        }
                    }

                    max2 = Math.abs(arrT[i][0]);
                    for (int j = 1; j < mash.getNy() - 1; j++) {
                        if (max2 < Math.abs(arrT[i][j])) {
                            max2 = Math.abs(arrT[i][j]);
                        }
                    }
                } while (
                        isEqual(max1 / max2, e)
                );
            }

        }
    }

//    public void saveToCSV(String filename, Mash mash) {
//        DecimalFormat decimalFormat = new DecimalFormat("#.###");
//        String result;
//        String[] resultArr = new String[mash.getNx()];
//
//        try (CSVWriter writer = new CSVWriter(new FileWriter(filename, true))) {
//            for (int j = mash.getNy() - 1; j >= 0; j--) {
//                for (int i = 0; i < mash.getNx(); i++) {
//                    result = decimalFormat.format(arrT[i][j]);
//                    resultArr[i] = result;
//                }
//                writer.writeNext(resultArr);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void printResultAtDot(int dot_i, int dot_j, String filename) {
        int d = 1;
//        Integer countTauOnTheStep = (int) Math.round(printIterStep / tau);
//        Integer countStep = (int) Math.round(end / printIterStep);

        double[][] forPrint = new double[2][arrTmemory.size()];

        System.out.println("Изменение температуры за весь период расчета в узле расчетной сетки с координатами: X - " + dot_i + " и Y - " + dot_j);
        while (d <= arrTmemory.size()) {
            forPrint[0][d - 1] = d;
            forPrint[1][d - 1] = arrTmemory.get(d)[dot_i][dot_j];
            d += 1;
        }


//        try (CSVWriter writer = new CSVWriter(new FileWriter(filename, true))) {
//            String resultCSV[] = new String[forPrint[1].length];
//            for (double[][] arr : arrTmemory) {
//                counter2 += 1;
//                if (counter2 == countTauOnTheStep) {
//                    d += 1;
//                    forPrint[0][d - 1] = d;
//                    forPrint[1][d - 1] = arr[dot_i][dot_j];
//                    resultCSV[d - 2] = decimalFormat2.format(forPrint[1][d - 1]);
//                    counter2 = 0;
//                }
//            }
//            writer.writeNext(resultCSV);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        for (int i = 0; i < forPrint[0].length; i++) {
            System.out.print(String.format("%1$10.0f", forPrint[0][i]));
        }
        System.out.println("\n");
        for (int i = 0; i < forPrint[1].length; i++) {
            System.out.print(String.format("%1$10.6f", forPrint[1][i]));
        }
    }

    public void printResultLine(int section, Integer iteration) {
        double[][] arrIter = arrTmemory.get(iteration);
        String result;
        System.out.println("\n");
        System.out.println("Температура грунта в сечении параллельном оси X и с координатой узла по оси Y - " + section + ", в момент времени " + iteration * tau + " c");
        for (int i = 0; i < arrIter.length; i++) {
            result = String.format("%1$6.2f", arrIter[i][section]);
            System.out.print(result + " ");
        }
    }

    public void printResult(Integer iteration) {
        double[][] arrIter = arrTmemory.get(iteration);
        System.out.println("\n");
        System.out.println("Температура грунта на " + iteration + " итерации.");
        for (int j = arrIter[0].length - 1; j >= 0; j--) {
            System.out.println("\n");
            for (int i = 0; i < arrIter.length; i++) {
                String format = String.format("%1$6.2f", arrIter[i][j]);
                System.out.print(format);
            }
        }
    }
}