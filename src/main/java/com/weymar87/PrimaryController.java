package com.weymar87;

import java.io.IOException;

import com.weymar87.climate.Climate;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PrimaryController {

    private Main mainApp;
    @FXML
    private TableView<Climate> climate;
    @FXML
    private TableColumn<Climate, Double> january;
    @FXML
    private TableColumn<Climate, Double> february;
    @FXML
    private TableColumn<Climate, Double> march;
    @FXML
    private TableColumn<Climate, Double> april;
    @FXML
    private TableColumn<Climate, Double> may;
    @FXML
    private TableColumn<Climate, Double> june;
    @FXML
    private TableColumn<Climate, Double> july;
    @FXML
    private TableColumn<Climate, Double> august;
    @FXML
    private TableColumn<Climate, Double> september;
    @FXML
    private TableColumn<Climate, Double> october;
    @FXML
    private TableColumn<Climate, Double> november;
    @FXML
    private TableColumn<Climate, Double> december;

    public PrimaryController() {
    }
    @FXML
    private void initialize() {
january.setCellValueFactory(cellData -> cellData.getValue().getArrClimate()[0][1]);
//        january.setCellValueFactory(new PropertyValueFactory<Climate, Double>("0"));
//        february.setCellValueFactory(new PropertyValueFactory<Climate, Double>("0"));
//        march.setCellValueFactory(new PropertyValueFactory<Climate, Double>("0"));
//        april.setCellValueFactory(new PropertyValueFactory<Climate, Double>("0"));
//        may.setCellValueFactory(new PropertyValueFactory<Climate, Double>("0"));
//        june.setCellValueFactory(new PropertyValueFactory<Climate, Double>("0"));
//        july.setCellValueFactory(new PropertyValueFactory<Climate, Double>("0"));
//        august.setCellValueFactory(new PropertyValueFactory<Climate, Double>("0"));
//        september.setCellValueFactory(new PropertyValueFactory<Climate, Double>("0"));
//        october.setCellValueFactory(new PropertyValueFactory<Climate, Double>("0"));
//        november.setCellValueFactory(new PropertyValueFactory<Climate, Double>("0"));
//        december.setCellValueFactory(new PropertyValueFactory<Climate, Double>("0"));

//                cellData -> cellData.getValue().getArrClimate()[0][1]
    }


    @FXML
    public void buttonExit(Event e){

    }

    public void setClimate(Main mainApp) {
        this.mainApp = mainApp;
        climate.setItems(mainApp.getClimateData());
    }



    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
