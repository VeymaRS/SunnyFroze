package com.weymar87.soil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SoilBase {
    ObservableList<Soil> soilList;


    public SoilBase() {
        this.soilList = FXCollections.observableArrayList();
        addSoil();
    }

    public void addSoil() {this.soilList.add(new Soil("IGE1", "SAND", 0.00, 0.0, 0, 0.0,
            0.0, 0.0, 0.0, 0,
            0.0E6, 0.0E6, 0.0, 0.0, 0.0, 0));}

    public ObservableList<Soil> getSoilList() {
        return soilList;
    }
    public Soil getSoil (int index) {
        Soil soil = soilList.get(index);
        return soil;
    }
}


