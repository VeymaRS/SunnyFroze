package com.weymar87;

import java.io.IOException;

import com.weymar87.climate.Climate;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

public class PrimaryController {

//    private Main mainApp;
//
    @FXML
    private TableView<Climate> climate;
    @FXML
    private TableColumn<Climate, Double> january;
    @FXML
    private TableColumn<Climate, Double> february;
    @FXML
    private TableColumn<Climate, Double> march;
    @FXML
    private TableColumn<Climate, String> april;
    @FXML
    private TableColumn<Climate, String> may;
    @FXML
    private TableColumn<Climate, String> june;
    @FXML
    private TableColumn<Climate, String> july;
    @FXML
    private TableColumn<Climate, String> august;
    @FXML
    private TableColumn<Climate, String> september;
    @FXML
    private TableColumn<Climate, String> october;
    @FXML
    private TableColumn<Climate, String> november;
    @FXML
    private TableColumn<Climate, String> december;

    public PrimaryController() {
    }
    @FXML
    private void initialize() {

january.setCellValueFactory(cellData -> cellData.getValue().getArrClimate()[0][1]);
    }

        public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        climate.setItems(mainApp.getClimateObservableList());
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
