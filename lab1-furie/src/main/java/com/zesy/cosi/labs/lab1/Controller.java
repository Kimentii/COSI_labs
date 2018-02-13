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


    public void initialize() {
        createGraphicButton.setOnMouseClicked((MouseEvent event) -> {
            GraphicsCreator.showGraphic(firstLineChart, FUNCTION, PERIOD, N);

            Complex discreteFourierTransformResult[] = FourierFunctions.getDiscreteFourierTransform(FUNCTION, PERIOD, N);
            GraphicsCreator.showGraphic(secondLineChart, discreteFourierTransformResult);

            Complex fastFourierTransformResult[] = FourierFunctions.getFastFourierTransform(FUNCTION, PERIOD, N);
            GraphicsCreator.showGraphic(thirdLineChart, fastFourierTransformResult);
            System.out.println(fastFourierTransformResult.length);

            double reverseFourierTransformResult[] = FourierFunctions.getReverseFourierTransform(discreteFourierTransformResult, PERIOD, N);
            GraphicsCreator.showGraphic(fourthLineChart, reverseFourierTransformResult, PERIOD);

        });
    }
}
