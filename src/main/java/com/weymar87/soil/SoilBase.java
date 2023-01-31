package com.weymar87.soil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SoilBase {
    ObservableList<Soil> soilList = FXCollections.observableArrayList();
    public ObservableList<Soil> getSoilList() {
        return FXCollections.observableArrayList();
    }

    public void addSoil(Soil soil) {this.soilList.add(soil);}

    public Soil getSoil (int index) {
        Soil soil = soilList.get(index);
        return soil;
    }



}


