package com.weymar87.mash;

import com.weymar87.soil.Soil;
import com.weymar87.soil.SoilBase;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Iterator;

public class Mash {


    double L;
    double H;

    double hx;
    double hy;

    int Nx = (int) Math.round((L / hx) + 1);
    int Ny = (int) Math.round((H / hy) + 1);

    double h_min;
    double c_min;
    double lamda_max;
    private Soil[][] arrSoilMash;
    private double[][] arrTempOnTheMash;

    int[][] arrGUonTheMash;



    public void createSoilMash() {
        arrSoilMash = new Soil[Nx][Ny];
    }

    public void createArrTempOnTheMash() {
        arrTempOnTheMash = new double[Nx][Ny];
    }

    public Soil[][] getArrSoilMash() {
        return arrSoilMash;
    }

    public double[][] getArrTempOnTheMash() {
        return arrTempOnTheMash;
    }

    public Soil getSoil(int i, int j) {
        return arrSoilMash[i][j];
    }

    public double get_h_min() {
        if (hx < hy) {
            h_min = hx;
        } else {
            h_min = hy;
        }
        return h_min;
    }

    public void putSoilsOnTheMash(SoilBase soilBase) {
        Iterator<Soil> iter = soilBase.getSoilList().iterator();
        int y = arrSoilMash[0].length - 1;

        while (iter.hasNext()) {
            Soil soil = iter.next();
            int soilLength = (int) (Math.round(soil.getSoilWidth() / hy));
            for (int j = y; j >= y - soilLength; j--) {
                arrSoilMash[0][j] = soil;
            }
            y = y - soilLength;
            if (y <= 0) {
                break;
            }
        }
        for (int j = arrSoilMash[0].length - 1; j >= 0; j--) {
            if (arrSoilMash[0][j] != null) {
                continue;
            } else {
                arrSoilMash[0][j] = arrSoilMash[0][j + 1];
            }
        }
        for (int j = 0; j < arrSoilMash[0].length; j++) {
            for (int i = 1; i < arrSoilMash.length; i++) {
                arrSoilMash[i][j] = arrSoilMash[0][j];
            }
        }
    }

    public void putTempOnTheMash(double[][] arrTemp) {
        int countY = arrTempOnTheMash[0].length - 1;
        double result = 0;
        int tempWidthInterval = 0;
        double iterInterval = 0;
        for (int i = 1; i <= arrTemp[0].length; i++) {
            iterInterval = Math.abs(arrTemp[0][i - 1]);
            tempWidthInterval = (int) Math.abs((Math.round((arrTemp[0][i] - arrTemp[0][i - 1]) / hy)));
            for (int j = countY; j >= countY - tempWidthInterval; j--) {
                iterInterval += hy;
                double x2 = Math.abs(arrTemp[0][i]);
                double x1 = Math.abs(arrTemp[0][i - 1]);
                double y2 = arrTemp[1][i];
                double y1 = arrTemp[1][i - 1];
                double alpha = (y2 - y1) / (x2 - x1);
                double beta = y1 - alpha * x1;
                result = alpha * iterInterval + beta;
                arrTempOnTheMash[0][j] = result;
            }
            countY -= tempWidthInterval;
            if (countY <= 0) {
                break;
            }
        }
        for (int j = 0; j < arrTempOnTheMash[0].length; j++) {
            for (int i = 1; i < arrTempOnTheMash.length; i++) {
                arrTempOnTheMash[i][j] = arrTempOnTheMash[0][j];
            }
        }
    }

    public void putGUonTheMash(int[][] arrGUonTheMash, int topGU, int leftGU, int rightGU) {
        for (int i = 0; i < Nx; i++) {
            for (int y = 0; y < Ny; y++) {
                arrGUonTheMash[i][y] = 4;
            }
        }
        for (int i = 0; i < Nx; i++) {
            arrGUonTheMash[i][Ny - 1] = topGU;
        }
        for (int y = 0; y < Ny; y++) {
            arrGUonTheMash[0][y] = leftGU;
        }
        for (int y = 0; y < Ny; y++) {
            arrGUonTheMash[Nx - 1][y] = rightGU;
        }
    }

    public void putTubeOnTheMash(double centerX, double centerY, double diameter) {

        for (int i = 0; i < Nx; i++) {
            for (int j = 0; j < Ny; j++) {

            }
        }
    }

    public void set_C_min(SoilBase soilBase) {
        c_min = soilBase.getSoil(0).getCf();
        Iterator<Soil> iter = soilBase.getSoilList().iterator();
        while (iter.hasNext()) {
            Soil soil = iter.next();
            if (soil.getCf() < c_min)
                c_min = soil.getCf();
        }
    }

    public void set_Lamd_max(SoilBase soilBase) {
        lamda_max = soilBase.getSoil(0).getLamda_f();
        Iterator<Soil> iter = soilBase.getSoilList().iterator();
        while (iter.hasNext()) {
            Soil soil = iter.next();
            if (soil.getLamda_f() > lamda_max)
                lamda_max = soil.getLamda_f();
        }
    }

    public double getC_min() {
        return c_min;
    }

    public double getLamda_max() {
        return lamda_max;
    }

    public double getL() {
        return L;
    }

    public double getH() {
        return H;
    }

    public double getHx() {
        return hx;
    }

    public double getHy() {
        return hy;
    }

    public int getNx() {
        return Nx;
    }

    public int getNy() {
        return Ny;
    }

    public double getH_min() {
        return h_min;
    }

    public void setL(double l) {
        L = l;
    }

    public void setH(double h) {
        H = h;
    }

    public void setHx(double hx) {
        this.hx = hx;
    }

    public void setHy(double hy) {
        this.hy = hy;
    }

    public int[][] getArrGUonTheMash() {
        return arrGUonTheMash;
    }
}
