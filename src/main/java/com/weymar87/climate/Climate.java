package com.weymar87.climate;

import javafx.beans.property.SimpleDoubleProperty;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

public class Climate {
//    private double[][] arrClimate;
    private SimpleDoubleProperty[][] arrClimate;
    private double lamdaSnow;
    private Calendar startDate;

    //    public double interpolation(Double[] arr, double a) {
//        double result = 0;
//            for (int i = 0; i < arr.length; i++) {
//                if (a >= arr[i]) {
//                    double x2 = arr[i];
//                    double x1 = arr[i - 1];
//                    double y2 = arr[t][i];
//                    double y1 = arr[t][i - 1];
//                    result = y1 + (T - x1) * (y2 - y1) / (x2 - x1);
//                    break;
//                }
//            }
//        return result;
//    }



    public Climate() {
        this.arrClimate = new SimpleDoubleProperty[12][2];
        int m = 0;
        for (int i = 0; i < arrClimate.length; i++) {
            arrClimate[i][0] = new SimpleDoubleProperty(m);
            arrClimate[i][1] = new SimpleDoubleProperty(m+1);
            m += 1;
        }
    }

    public void addTemp(double januaryTemp, double februaryTemp, double marchTemp, double aprilTemp, double mayTemp,
                        double juneTemp, double julyTemp, double augustTemp, double septemberTemp, double octoberTemp,
                        double novemberTemp, double decemberTemp) {

        arrClimate[0][1] = new SimpleDoubleProperty(januaryTemp);
        arrClimate[1][1] = new SimpleDoubleProperty(februaryTemp);
        arrClimate[2][1] = new SimpleDoubleProperty(marchTemp);
        arrClimate[3][1] = new SimpleDoubleProperty(aprilTemp);
        arrClimate[4][1] = new SimpleDoubleProperty(mayTemp);
        arrClimate[5][1] = new SimpleDoubleProperty(juneTemp);
        arrClimate[6][1] = new SimpleDoubleProperty(julyTemp);
        arrClimate[7][1] = new SimpleDoubleProperty(augustTemp);
        arrClimate[8][1] = new SimpleDoubleProperty(septemberTemp);
        arrClimate[9][1] = new SimpleDoubleProperty(octoberTemp);
        arrClimate[10][1] = new SimpleDoubleProperty(novemberTemp);
        arrClimate[11][1] = new SimpleDoubleProperty(decemberTemp);
    }

    public SimpleDoubleProperty[][] getArrClimate() {
        return arrClimate;
    }

    public double getLamdaSnow() {
        return lamdaSnow;
    }

    public void setLamdaSnow(double lamdaSnow) {
        this.lamdaSnow = lamdaSnow;
    }
    public void setNewValue(int month, Double value) {
        SimpleDoubleProperty v = new SimpleDoubleProperty(value);
        arrClimate[month][1] = v;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void calcAlphaWithSnow() {
        for (int i = 0; i < arrClimate.length; i++) {
            if (arrClimate[i][2].get() < 5 & arrClimate[i][2].get() > 0) {
                arrClimate[i][4].set(1 / (1 / (6.16 + 4.19 * arrClimate[i][2].get()) + arrClimate[i][3].get()
                        / lamdaSnow));
            } else {
                arrClimate[i][4].set(1 / (1 / (7.56 * Math.pow(arrClimate[i][2].get(), 0.78)) + arrClimate[i][3].get()
                        / lamdaSnow));
            }
        }
    }

    public Double interpolationForClimate(double time, double tempTrend) {
        Double result = 0.0;
        Map<Calendar, Double[]> valueLeft;
        Calendar val1;
        Calendar val2;
        long x1 = 0;
        long x2 = 0;
        double y1 = 0;
        double y2 = 0;
        int t = (int) time;
        Calendar calendarCurrent = startDate;
        calendarCurrent.add(Calendar.SECOND, t);
        int currentMonth = calendarCurrent.get(Calendar.MONTH);
        int currentDayInMonth = calendarCurrent.get(Calendar.DAY_OF_MONTH);
        double trend = tempTrend * (calendarCurrent.get(Calendar.YEAR) - startDate.get(Calendar.YEAR));

        for (int i = 0; i < arrClimate.length; i++) {
            if (currentMonth == arrClimate[i][0].get()) {
                if (currentDayInMonth > 15) {
                    if (i == 11) {
                        val1 = new GregorianCalendar(calendarCurrent.get(Calendar.YEAR),
                                calendarCurrent.get(Calendar.MONTH), 15);
                        val2 = new GregorianCalendar(calendarCurrent.get(Calendar.YEAR) + 1,
                                calendarCurrent.get(Calendar.MONTH) + 1, 15);
                        x1 = val1.getTimeInMillis();
                        x2 = val2.getTimeInMillis();
                        y1 = arrClimate[i][1].get() + trend;
                        y2 = arrClimate[0][1].get() + trend;
                    } else {
                        val1 = new GregorianCalendar(calendarCurrent.get(Calendar.YEAR),
                                calendarCurrent.get(Calendar.MONTH), 15);
                        val2 = new GregorianCalendar(calendarCurrent.get(Calendar.YEAR),
                                calendarCurrent.get(Calendar.MONTH) + 1, 15);
                        x1 = val1.getTimeInMillis();
                        x2 = val2.getTimeInMillis();
                        y1 = arrClimate[i][1].get() + trend;
                        y2 = arrClimate[i + 1][1].get() + trend;
                    }
                } else if (currentDayInMonth <= 15) {
                    if (i == 0) {
                        val1 = new GregorianCalendar(calendarCurrent.get(Calendar.YEAR) - 1,
                                11, 15);
                        val2 = new GregorianCalendar(calendarCurrent.get(Calendar.YEAR),
                                calendarCurrent.get(Calendar.MONTH), 15);
                        x1 = val1.getTimeInMillis();
                        x2 = val2.getTimeInMillis();
                        y1 = arrClimate[11][1].get() + trend;
                        y2 = arrClimate[i][1].get() + trend;
                    } else {
                        val1 = new GregorianCalendar(calendarCurrent.get(Calendar.YEAR),
                                calendarCurrent.get(Calendar.MONTH) - 1, 15);
                        val2 = new GregorianCalendar(calendarCurrent.get(Calendar.YEAR),
                                calendarCurrent.get(Calendar.MONTH), 15);
                        x1 = val1.getTimeInMillis();
                        x2 = val2.getTimeInMillis();
                        y1 = arrClimate[i - 1][1].get() + trend;
                        y2 = arrClimate[i][1].get() + trend;
                    }
                }
            }
        }
        double alpha = (y2 - y1) / (x2 - x1);
        double beta = y1 - alpha * x1;
        result = alpha * calendarCurrent.getTimeInMillis() + beta;
        return result;
    }
}

