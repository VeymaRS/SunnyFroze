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

    SimpleDoubleProperty soilWidth;

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
        this.soilWidth = new SimpleDoubleProperty(soilWidth);
        if (typeSoil.equals("SAND")) {
            this.arrWwSoil = new double[2][2];
        } else {
            this.arrWwSoil = new double[2][11];
        }
    }


    public String getNameSoil() {
        return nameSoil.get();
    }

    public SimpleStringProperty nameSoilProperty() {
        return nameSoil;
    }

    public String getTypeSoil() {
        return typeSoil.get();
    }

    public SimpleStringProperty typeSoilProperty() {
        return typeSoil;
    }

    public double getLp() {
        return Lp.get();
    }

    public SimpleDoubleProperty lpProperty() {
        return Lp;
    }

    public double getWtot() {
        return Wtot.get();
    }

    public SimpleDoubleProperty wtotProperty() {
        return Wtot;
    }

    public double getRod() {
        return rod.get();
    }

    public SimpleDoubleProperty rodProperty() {
        return rod;
    }

    public double getWp() {
        return Wp.get();
    }

    public SimpleDoubleProperty wpProperty() {
        return Wp;
    }

    public double getWm() {
        return Wm.get();
    }

    public SimpleDoubleProperty wmProperty() {
        return Wm;
    }

    public double getTbf() {
        return Tbf.get();
    }

    public SimpleDoubleProperty tbfProperty() {
        return Tbf;
    }

    public double getLambda_th() {
        return lambda_th.get();
    }

    public SimpleDoubleProperty lambda_thProperty() {
        return lambda_th;
    }

    public double getLamda_f() {
        return lamda_f.get();
    }

    public SimpleDoubleProperty lamda_fProperty() {
        return lamda_f;
    }

    public double getCth() {
        return cth.get();
    }

    public SimpleDoubleProperty cthProperty() {
        return cth;
    }

    public double getCf() {
        return cf.get();
    }

    public SimpleDoubleProperty cfProperty() {
        return cf;
    }

    public double getDsal() {
        return Dsal.get();
    }

    public SimpleDoubleProperty dsalProperty() {
        return Dsal;
    }

    public double getItot() {
        return itot.get();
    }

    public SimpleDoubleProperty itotProperty() {
        return itot;
    }

    public double getJ() {
        return j.get();
    }

    public SimpleDoubleProperty jProperty() {
        return j;
    }

    public double getSoilWidth() {
        return soilWidth.get();
    }

    public SimpleDoubleProperty soilWidthProperty() {
        return soilWidth;
    }

    public void setNameSoil(String nameSoil) {
        this.nameSoil.set(nameSoil);
    }

    public void setTypeSoil(String typeSoil) {
        this.typeSoil.set(typeSoil);
    }

    public void setLp(double lp) {
        this.Lp.set(lp);
    }

    public void setWtot(double wtot) {
        this.Wtot.set(wtot);
    }

    public void setRod(double rod) {
        this.rod.set(rod);
    }

    public void setWp(double wp) {
        this.Wp.set(wp);
    }

    public void setWm(double wm) {
        this.Wm.set(wm);
    }

    public void setTbf(double tbf) {
        this.Tbf.set(tbf);
    }

    public void setLambda_th(double lambda_th) {
        this.lambda_th.set(lambda_th);
    }

    public void setLamda_f(double lamda_f) {
        this.lamda_f.set(lamda_f);
    }

    public void setCth(double cth) {
        this.cth.set(cth);
    }

    public void setCf(double cf) {
        this.cf.set(cf);
    }

    public void setDsal(double dsal) {
        this.Dsal.set(dsal);
    }

    public void setItot(double itot) {
        this.itot.set(itot);
    }

    public void setJ(double j) {
        this.j.set(j);
    }

    public double[][] getArrWwSoil() {
        return arrWwSoil;
    }

    public void setSoilWidth(double soilWidth) {
        this.soilWidth.set(soilWidth);
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
