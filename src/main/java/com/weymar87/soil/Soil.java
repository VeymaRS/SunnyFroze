package com.weymar87.soil;

public class Soil {
    String nameSoil;
    String typeSoil; //SAND - песок; FINESAND - песок пылеватый; SILT - супесь; LEANCLAY - суглинок; FATCLAY - глина; PEAT - торф
    double Lp;
    double Wtot;
    double rod;
    double Wp;
    double Wm;
    double Tbf;
    double lambda_th;
    double lamda_f;
    double cth;
    double cf;
    double Dsal;
    double itot;
    double j;

    double[][] arrWwSoil;

    double soilWidth;

    public Soil() {
    }

    public Soil(String nameSoil, String typeSoil, double Lp, double Wtot, double rod, double Wp,
                double Wm, double tbf, double lambda_th, double lamda_f, double cth, double cf,
                double Dsal, double itot, double j, double soilWidth) {
        this.nameSoil = nameSoil;
        this.typeSoil = typeSoil;
        this.Lp = Lp;
        this.Wtot = Wtot;
        this.rod = rod;
        this.Tbf = tbf;
        this.lambda_th = lambda_th;
        this.lamda_f = lamda_f;
        this.cth = cth;
        this.cf = cf;
        this.Dsal = Dsal;
        this.itot = itot;
        this.Wp = Wp;
        this.Wm = Wm;
        this.j = j;
        this.soilWidth = soilWidth;
        if (typeSoil.equals("SAND")) {
            this.arrWwSoil = new double[2][2];
        } else {
            this.arrWwSoil = new double[2][11];
        }
    }

    public String getNameSoil() {
        return nameSoil;
    }

    public String getTypeSoil() {
        return typeSoil;
    }

    public double getLp() {
        return Lp;
    }

    public double getWtot() {
        return Wtot;
    }

    public double getRod() {
        return rod;
    }

    public double getWp() {
        return Wp;
    }

    public double getWm() {
        return Wm;
    }

    public double getTbf() {
        return Tbf;
    }

    public double getLambda_th() {
        return lambda_th;
    }

    public double getLamda_f() {
        return lamda_f;
    }

    public double getCth() {
        return cth;
    }

    public double getCf() {
        return cf;
    }

    public double getDsal() {
        return Dsal;
    }

    public double getItot() {
        return itot;
    }

    public double getJ() {
        return j;
    }

    public double getSoilWidth() {
        return soilWidth;
    }

    public double[][] getArrWwSoil() {
        return arrWwSoil;
    }

    public void setNameSoil(String nameSoil) {
        this.nameSoil = nameSoil;
    }

    public void setTypeSoil(String typeSoil) {
        this.typeSoil = typeSoil;
    }


    public void setLp(double lp) {
        Lp = lp;
    }

    public void setWtot(double wtot) {
        Wtot = wtot;
    }

    public void setRod(double rod) {
        this.rod = rod;
    }

    public void setWp(double wp) {
        Wp = wp;
    }

    public void setWm(double wm) {
        Wm = wm;
    }

    public void setTbf(double tbf) {
        Tbf = tbf;
    }

    public void setLambda_th(double lambda_th) {
        this.lambda_th = lambda_th;
    }

    public void setLamda_f(double lamda_f) {
        this.lamda_f = lamda_f;
    }

    public void setCth(double cth) {
        this.cth = cth;
    }

    public void setCf(double cf) {
        this.cf = cf;
    }

    public void setDsal(double dsal) {
        Dsal = dsal;
    }

    public void setItot(double itot) {
        this.itot = itot;
    }

    public void setJ(double j) {
        this.j = j;
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
