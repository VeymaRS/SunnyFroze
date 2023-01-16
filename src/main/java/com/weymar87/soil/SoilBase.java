package com.weymar87.soil;

import java.util.ArrayList;
import java.util.List;

public class SoilBase {
    public List<Soil> getSoilList() {
        return new ArrayList<>(soilList);
    }

    public void addSoil(Soil soil) {this.soilList.add(soil);}

    public Soil getSoil (int index) {
        Soil soil = soilList.get(index);
        return soil;
    }
    List<Soil> soilList = new ArrayList<>();


}


