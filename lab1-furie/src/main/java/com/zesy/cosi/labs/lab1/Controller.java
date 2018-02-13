package com.zesy.cosi.labs.lab1;

import com.zesy.cosi.labs.Complex;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    Button createGraphicButton;
    @FXML
    LineChart<Number, Number> firstLineChart;
    @FXML
    LineChart<Number, Number> secondLineChart;
    @FXML
    LineChart<Number, Number> thirdLineChart;
    @FXML
    LineChart<Number, Number> fourthLineChart;
    @FXML
    LineChart<Number, Number> fifthLineChart;


    public void initialize() {
        Complex[] values = new Complex[20];
        for (int i = 0; i < values.length; i++) {
            values[i] = new Complex(i + 1, i * 2);
        }
        double ys[] = new double[10];
        for (int i = 0; i < ys.length; i++) {
            ys[i] = i + 1;
        }
        GraphicsGreater.showGraphic(firstLineChart, values);
        GraphicsGreater.showGraphic(secondLineChart, ys, 1.5);
        createGraphicButton.setOnMouseClicked((MouseEvent event) -> {

        });
    }
}
