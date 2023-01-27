package com.weymar87;

import com.weymar87.climate.Climate;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.GregorianCalendar;

/**
 * JavaFX App
 */
public class App extends Application {


    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static void startSolve() {
        //        Neyavnaya_2D neyavnaya_2D = new Neyavnaya_2D();
//        Mash mash = new Mash();
//        mash.createSoilMash();
//        mash.createArrTempOnTheMash();
//        SoilBase soilBase = SoilBaseCreate.createBase();
//        mash.putSoilsOnTheMash(soilBase);
//        mash.putTempOnTheMash(new double[][]{{0, -0.5, -1, -1.5, -2, -2.5, -3, -3.5, -4, -4.5, -5, -6, -7, -8, -9, -10,
//                -12, -14},
//                {-20, -18, -16, -14, -12, -10, -8, -7, -2, -2, -2, -2, -2, -2, -2.3, -2.2, -2.5, -2.7}});
//        mash.set_C_min(soilBase);
//        mash.set_Lamd_max(soilBase);
//        Climate climate = ClimateCreate.climateCreate();

//        neyavnaya_2D.calculate_neyavnaya_2D(86400 * 30, mash, climate, 86400);
//        neyavnaya_2D.printResultAtDot(2, 95, "dot.csv");
//        neyavnaya_2D.printResultLine(99, 30);
//        neyavnaya_2D.printResult(30);


//        neyavnaya_2D.saveToCSV("result.csv", com.weymar87.mash);
    }

    public static void main(String[] args) {
        launch();
    }

}