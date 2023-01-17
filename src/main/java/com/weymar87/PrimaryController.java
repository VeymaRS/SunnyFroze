package com.weymar87;

import java.io.IOException;

import com.weymar87.climate.Climate;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
        this.mainApp = new Main();
        climate.setItems(mainApp.getClimateData());

        january.setCellValueFactory(cellData -> cellData.getValue().getArrClimate()[0][1].asObject());
        february.setCellValueFactory(cellData -> cellData.getValue().getArrClimate()[1][1].asObject());
        march.setCellValueFactory(cellData -> cellData.getValue().getArrClimate()[2][1].asObject());
        april.setCellValueFactory(cellData -> cellData.getValue().getArrClimate()[3][1].asObject());
        may.setCellValueFactory(cellData -> cellData.getValue().getArrClimate()[4][1].asObject());
        june.setCellValueFactory(cellData -> cellData.getValue().getArrClimate()[5][1].asObject());
        july.setCellValueFactory(cellData -> cellData.getValue().getArrClimate()[6][1].asObject());
        august.setCellValueFactory(cellData -> cellData.getValue().getArrClimate()[7][1].asObject());
        september.setCellValueFactory(cellData -> cellData.getValue().getArrClimate()[8][1].asObject());
        october.setCellValueFactory(cellData -> cellData.getValue().getArrClimate()[9][1].asObject());
        november.setCellValueFactory(cellData -> cellData.getValue().getArrClimate()[10][1].asObject());
        december.setCellValueFactory(cellData -> cellData.getValue().getArrClimate()[11][1].asObject());
    }


    @FXML
    public void buttonExit(Event e) {

    }

//    public void setClimate(Main mainApp) {
//        this.mainApp = mainApp;
//        climate.setItems(mainApp.getClimateData());
//    }


    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
