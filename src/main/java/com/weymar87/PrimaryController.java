package com.weymar87;

import java.io.IOException;

import com.weymar87.climate.Climate;
import com.weymar87.utils.ClimateBaseCreate;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

public class PrimaryController {

    private ClimateBaseCreate climateBaseCreate;
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

    @FXML
    private TextField field;

    @FXML
    private DatePicker startdate;

    @FXML
    private DatePicker startdate1;

    @FXML
    private Button btn;

    public PrimaryController() {
    }


    @FXML
    private void initialize() {
        this.climateBaseCreate = new ClimateBaseCreate();
        climate.setItems(climateBaseCreate.getClimateData());


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


        january.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        january.setOnEditCommit(
                t -> ((Climate) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setNewValue(0, t.getNewValue())
        );

        february.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        february.setOnEditCommit(
                t -> ((Climate) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setNewValue(1, t.getNewValue())
        );

        march.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        march.setOnEditCommit(
                t -> ((Climate) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setNewValue(2, t.getNewValue())
        );

        april.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        april.setOnEditCommit(
                t -> ((Climate) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setNewValue(3, t.getNewValue())
        );

        may.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        may.setOnEditCommit(
                t -> ((Climate) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setNewValue(4, t.getNewValue())
        );


        june.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        june.setOnEditCommit(
                t -> ((Climate) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setNewValue(5, t.getNewValue())
        );
        july.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        july.setOnEditCommit(
                t -> ((Climate) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setNewValue(6, t.getNewValue())
        );
        august.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        august.setOnEditCommit(
                t -> ((Climate) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setNewValue(7, t.getNewValue())
        );
        september.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));

        october.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));

        november.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));

        december.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
    }


    @FXML
    public void buttonExit(Event e) {

    }

    @FXML
    public void setData(ActionEvent event) {
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                startdate1.setValue(startdate.getValue());
                field.setText(
                        String.valueOf(
                                january.getTableView().getItems().get(0).getArrClimate()[5][1].getValue()).toString());
                field.setEditable(false);
            }
        });
    }

    @FXML
    public void setValue(ActionEvent event) {
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                startdate1.setValue(startdate.getValue());

            }
        });
    }

//    public void setClimate(Main climateBaseCreate) {
//        this.climateBaseCreate = climateBaseCreate;
//        climate.setItems(climateBaseCreate.getClimateData());
//    }


    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

}
