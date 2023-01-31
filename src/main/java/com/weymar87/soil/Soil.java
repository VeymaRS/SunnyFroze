package com.weymar87.soil;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Soil {
    SimpleStringProperty nameSoil;
    SimpleStringProperty typeSoil; //SAND - песок; FINESAND - песок пылеватый; SILT - супесь; LEANCLAY - суглинок; FATCLAY - глина; PEAT - торф
    SimpleDoubleProperty Lp;
    SimpleDoubleProperty Wtot;
    SimpleDoubleProperty rod;
    SimpleDoubleProperty Wp;
    SimpleDoubleProperty Wm;
    SimpleDoubleProperty Tbf;
    SimpleDoubleProperty lambda_th;
    SimpleDoubleProperty lamda_f;
    SimpleDoubleProperty cth;
    SimpleDoubleProperty cf;
    SimpleDoubleProperty Dsal;
    SimpleDoubleProperty itot;
    SimpleDoubleProperty j;

    double[][] arrWwSoil;

    double soilWidth;

    public Soil() {
    }

    public Soil(String nameSoil, String typeSoil, double Lp, double Wtot, double rod, double Wp,
                double Wm, double tbf, double lambda_th, double lamda_f, double cth, double cf,
                double Dsal, double itot, double j, double soilWidth) {
        this.nameSoil = new SimpleStringProperty(nameSoil);
        this.typeSoil = new SimpleStringProperty(typeSoil);
        this.Lp = new SimpleDoubleProperty(Lp);
        this.Wtot = new SimpleDoubleProperty(Wtot);
        this.rod = new SimpleDoubleProperty(rod);
        this.Tbf = new SimpleDoubleProperty(tbf);
        this.lambda_th = new SimpleDoubleProperty(lambda_th);
        this.lamda_f = new SimpleDoubleProperty(lamda_f);
        this.cth = new SimpleDoubleProperty(cth);
        this.cf = new SimpleDoubleProperty(cf);
        this.Dsal = new SimpleDoubleProperty(Dsal);
        this.itot = new SimpleDoubleProperty(itot);
        this.Wp = new SimpleDoubleProperty(Wp);
        this.Wm = new SimpleDoubleProperty(Wm);
        this.j = new SimpleDoubleProperty(j);
        this.soilWidth = soilWidth;
        if (typeSoil.equals("SAND")) {
            this.arrWwSoil = new double[2][2];
        } else {
            this.arrWwSoil = new double[2][11];
        }
    }


    public void setSoilWidth(double soilWidth) {
        this.soilWidth = soilWidth;
    }


    @Override
    public String toString() {
        return "nameSoil=" + nameSoil +
                ", typeSoil=" + typeSoil +
                ", Lp=" + Lp +
                ", Wtot=" + Wtot +
                ", rod=" + rod +
                ", Wp=" + Wp +
                ", Wm=" + Wm +
                ", Tbf=" + Tbf +
                ", lamda_th=" + lambda_th +
                ", lamda_f=" + lamda_f +
                ", cth=" + cth +
                ", cf=" + cf +
                ", Dsal=" + Dsal +
                ", itot=" + itot +
                ", j=" + j +
                ", soilWidth=" + soilWidth;
    }
}
