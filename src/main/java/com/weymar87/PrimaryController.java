package com.weymar87;

import java.io.IOException;

import com.weymar87.climate.Climate;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

public class PrimaryController {

//    private Main mainApp;
//
//    @FXML
//    private TableView<Climate> climate;
    @FXML
    private TableColumn<Climate, String> january;
    @FXML
    private TableColumn<Climate, String> february;
    @FXML
    private TableColumn<Climate, String> march;
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
//    @FXML
//    private TableColumn<Climate, String> december;
//
//    public PrimaryController() {
//    }
//    @FXML
//    private void initialize() {
//        january.setCellFactory(TextFieldTableCell.<Climate>forTableColumn());
//        february.setCellFactory(TextFieldTableCell.<Climate>forTableColumn());
//        march.setCellFactory(TextFieldTableCell.<Climate>forTableColumn());
//        april.setCellFactory(TextFieldTableCell.<Climate>forTableColumn());
//        may.setCellFactory(TextFieldTableCell.<Climate>forTableColumn());
//        june.setCellFactory(TextFieldTableCell.<Climate>forTableColumn());
//        july.setCellFactory(TextFieldTableCell.<Climate>forTableColumn());
//        august.setCellFactory(TextFieldTableCell.<Climate>forTableColumn());
//        september.setCellFactory(TextFieldTableCell.<Climate>forTableColumn());
//        october.setCellFactory(TextFieldTableCell.<Climate>forTableColumn());
//        november.setCellFactory(TextFieldTableCell.<Climate>forTableColumn());
//        december.setCellFactory(TextFieldTableCell.<Climate>forTableColumn());
//    }

    //    public void setMainApp(Main mainApp) {
//        this.mainApp = mainApp;
//        climate.setItems(mainApp.getClimateObservableList());
//    }
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
