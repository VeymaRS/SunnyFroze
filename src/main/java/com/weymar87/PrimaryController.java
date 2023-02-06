package com.weymar87;

import java.io.IOException;

import com.weymar87.climate.Climate;
import com.weymar87.mash.Mash;
import com.weymar87.soil.Soil;
import com.weymar87.soil.SoilBase;
import com.weymar87.utils.ClimateBaseCreate;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

public class PrimaryController {

    private ClimateBaseCreate climateBaseCreate;
    private SoilBase soilBase;

    private Mash mash;
    @FXML
    private TableView<Climate> climate;

    @FXML
    private TableView<Soil> soils;

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
    private TableColumn<Soil, String> soilName;

    @FXML
    private TableColumn<Soil, String> typeSoil;
    @FXML
    private TableColumn<Soil, Double> Wtot;
    @FXML
    private TableColumn<Soil, Double> Wp;
    @FXML
    private TableColumn<Soil, Double> Tbf;
    @FXML
    private TableColumn<Soil, Double> lambda_th;
    @FXML
    private TableColumn<Soil, Double> lambda_f;
    @FXML
    private TableColumn<Soil, Double> cth;
    @FXML
    private TableColumn<Soil, Double> cf;
    @FXML
    private TableColumn<Soil, Double> Dsal;
    @FXML
    private TableColumn<Soil, Double> soilWidth;
    @FXML
    private TextField field;

    @FXML
    private DatePicker startdate;

    @FXML
    private DatePicker startdate1;

    @FXML
    private Button btn;

    @FXML
    private Button addSoilBtn;

    @FXML
    private TextField HyUI;
    @FXML
    private TextField HxUI;

    @FXML
    static TextField LUI;
    @FXML
    static TextField HUI;

    @FXML
    static TextField LUIexp;

    public PrimaryController() {
    }


    @FXML
    private void initialize() {
        this.climateBaseCreate = new ClimateBaseCreate();
        this.soilBase = new SoilBase();
        this.mash = new Mash();
        mash.createSoilMash();
        mash.createArrTempOnTheMash();

        climate.setItems(climateBaseCreate.getClimateData());
        climate.setFixedCellSize(35);
        soils.setFixedCellSize(25);
        soils.setItems(soilBase.getSoilList());


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

        soilName.setCellValueFactory(cellData -> cellData.getValue().nameSoilProperty());
        typeSoil.setCellValueFactory(cellData -> cellData.getValue().typeSoilProperty());
        Wtot.setCellValueFactory(cellData -> cellData.getValue().wtotProperty().asObject());
        Wp.setCellValueFactory(cellData -> cellData.getValue().wpProperty().asObject());
        Tbf.setCellValueFactory(cellData -> cellData.getValue().tbfProperty().asObject());
        lambda_th.setCellValueFactory(cellData -> cellData.getValue().lambda_thProperty().asObject());
        lambda_f.setCellValueFactory(cellData -> cellData.getValue().lambda_thProperty().asObject());
        cth.setCellValueFactory(cellData -> cellData.getValue().cthProperty().asObject());
        cf.setCellValueFactory(cellData -> cellData.getValue().cfProperty().asObject());
        Dsal.setCellValueFactory(cellData -> cellData.getValue().dsalProperty().asObject());
        soilWidth.setCellValueFactory(cellData -> cellData.getValue().soilWidthProperty().asObject());

//        HUI.setText("0");
//        LUI.setText("0");
//        HxUI.setText("0");
//        HyUI.setText("0");

        january.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        january.setOnEditCommit(
                t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNewValue(0, t.getNewValue())
        );

        february.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        february.setOnEditCommit(
                t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNewValue(1, t.getNewValue())
        );

        march.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        march.setOnEditCommit(
                t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNewValue(2, t.getNewValue())
        );

        april.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        april.setOnEditCommit(
                t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNewValue(3, t.getNewValue())
        );

        may.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        may.setOnEditCommit(
                t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNewValue(4, t.getNewValue())
        );


        june.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        june.setOnEditCommit(
                t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNewValue(5, t.getNewValue())
        );
        july.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        july.setOnEditCommit(
                t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNewValue(6, t.getNewValue())
        );
        august.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        august.setOnEditCommit(
                t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNewValue(7, t.getNewValue())
        );
        september.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        september.setOnEditCommit(
                t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNewValue(8, t.getNewValue())
        );


        october.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        october.setOnEditCommit(
                t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNewValue(9, t.getNewValue())
        );


        november.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        november.setOnEditCommit(
                t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNewValue(10, t.getNewValue())
        );

        december.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        december.setOnEditCommit(
                t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNewValue(10, t.getNewValue())
        );

        soilName.setCellFactory(TextFieldTableCell.forTableColumn());
        soilName.setOnEditCommit(
                t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNameSoil(t.getNewValue())
        );
        typeSoil.setCellFactory(TextFieldTableCell.forTableColumn());
        typeSoil.setOnEditCommit(
                t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNameSoil(t.getNewValue())
        );
        Wtot.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        Wp.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        Tbf.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        lambda_th.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        lambda_f.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        cth.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        cf.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        Dsal.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));
        soilWidth.setCellFactory(TextFieldTableCell.forTableColumn((new DoubleStringConverter())));

    }


    @FXML
    public void buttonExit(Event e) {

    }

    @FXML
    public void setData(ActionEvent event) {
        btn.setOnAction(actionEvent -> {
            startdate1.setValue(startdate.getValue());
            field.setText(
                    String.valueOf(
                            january.getTableView().getItems().get(0).getArrClimate()[5][1].getValue()).toString());
            field.setEditable(false);
        });
    }

    @FXML
    public void setValueHxUI(ActionEvent event) {
        mash.setHx(Double.parseDouble(HxUI.getText()));
        LUIexp.setText(String.valueOf(mash.getHx()));
    }

    @FXML
    public void addSoilAction(ActionEvent actionEvent) {
        addSoilBtn.setOnAction(actionEvent1 -> soilBase.addSoil());
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
