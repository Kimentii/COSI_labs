package com.zesy.cosi.labs.lab1;

import com.zesy.cosi.labs.Complex;
import com.zesy.cosi.labs.FourierFunctions;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.util.function.Function;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Controller {
    public static final int N = 32;
    public static final double PERIOD = 2 * PI;
    public static final Function<Double, Double> FUNCTION = (x) -> sin(6 * x) + cos(5 * x);

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
/*        Complex[] values = new Complex[20];
        for (int i = 0; i < values.length; i++) {
            values[i] = new Complex(i + 1, i * 2);
        }
        double ys[] = new double[10];
        for (int i = 0; i < ys.length; i++) {
            ys[i] = i + 1;
        }*/
        GraphicsCreator.showGraphic(firstLineChart, FUNCTION, PERIOD, N);
        Complex C[] = FourierFunctions.getDiscreteFourierTransform(FUNCTION, PERIOD, N);
        GraphicsCreator.showGraphic(secondLineChart, C);
        double X[] = FourierFunctions.getReverseFourierTransform(C, PERIOD, N);
        GraphicsCreator.showGraphic(thirdLineChart, X, PERIOD);
        createGraphicButton.setOnMouseClicked((MouseEvent event) -> {

        });
    }
}
