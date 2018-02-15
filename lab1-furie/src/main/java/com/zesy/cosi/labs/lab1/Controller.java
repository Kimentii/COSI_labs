package com.zesy.cosi.labs.lab1;

import com.zesy.cosi.labs.Complex;
import com.zesy.cosi.labs.FourierFunctions;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    @FXML
    Label discreteCalculationsLabel;
    @FXML
    Label fastCalculationsLabel;


    public void initialize() {
//        createGraphicButton.setOnMouseClicked((MouseEvent event) -> {
//            GraphicsCreator.showGraphic(firstLineChart, FUNCTION, PERIOD, N, "Исходный");
//
//            Complex discreteFourierTransformResult[] = FourierFunctions.getDiscreteFourierTransform(FUNCTION, PERIOD, N);
//
//            GraphicsCreator.showGraphicRe(secondLineChart, discreteFourierTransformResult, "Амплитуды ДПФ");
//            GraphicsCreator.showGraphicIm(thirdLineChart, discreteFourierTransformResult, "Фазы ДПФ");
//
//
//            Complex fastFourierTransformResult[] = FourierFunctions.getFastFourierTransform(FUNCTION, PERIOD, N);
//
//            System.out.println("-----Дискретное-----");
//            for(int i = 0; i < N; i++) {
//                System.out.println("C["+i+"]="+discreteFourierTransformResult[i] + "  ===  " + "C["+i+"]="+fastFourierTransformResult[i]);
//                System.out.println("C["+i+"]=("+discreteFourierTransformResult[i].abs()+", " + discreteFourierTransformResult[i].phase() + ")  ===   " +
//                        "C["+i+"]=("+fastFourierTransformResult[i].abs()+", " + fastFourierTransformResult[i].phase() + ")");
//            }
//
//            GraphicsCreator.showGraphicRe(fourthLineChart, fastFourierTransformResult, "Амплитуды БПФ");
//            GraphicsCreator.showGraphicIm(fifthLineChart, fastFourierTransformResult, "Фазы БПФ");
//        });
//
        createGraphicButton.setOnMouseClicked((MouseEvent event) -> {
            GraphicsCreator.showGraphic(firstLineChart, FUNCTION, PERIOD, N, "Исходный");

            Complex discreteFourierTransformResult[] = FourierFunctions.getDiscreteFourierTransform(FUNCTION, PERIOD, N);
            System.out.println("-----Дискретное-----");
            for(int i = 0; i < N; i++) {
                System.out.println("C["+i+"]="+discreteFourierTransformResult[i]);
            }
            GraphicsCreator.showGraphic(secondLineChart, discreteFourierTransformResult, "Прямое ДПФ");
            discreteCalculationsLabel.setText("+: " + Complex.getPlusCounter() + Complex.getPlusCounter()
                    + "; *: " + Complex.getMultiplyCounter());
            Complex.nullifyAllCounters();

            Complex fastFourierTransformResult[] = FourierFunctions.getFastFourierTransform(FUNCTION, PERIOD, N);
            System.out.println("-----Обратное-----");
            for(int i = 0; i < N; i++) {
                System.out.println("C["+i+"]="+discreteFourierTransformResult[i]);
            }
            GraphicsCreator.showGraphic(thirdLineChart, discreteFourierTransformResult, "Прямое БПФ");
            fastCalculationsLabel.setText("+: " + Complex.getPlusCounter() + Complex.getPlusCounter()
                    + "; *: " + Complex.getMultiplyCounter());

            double reverseFourierTransformResult[] = FourierFunctions.getReverseFourierTransform(discreteFourierTransformResult, PERIOD, N);
            GraphicsCreator.showGraphic(fourthLineChart, reverseFourierTransformResult, PERIOD, "Обратное ДПФ");

            reverseFourierTransformResult = FourierFunctions.getReverseFourierTransform(fastFourierTransformResult, PERIOD, N);
            GraphicsCreator.showGraphic(fifthLineChart, reverseFourierTransformResult, PERIOD, "Обратное БПФ");

        });
//        createGraphicButton.setOnMouseClicked((MouseEvent event) -> {
//            GraphicsCreator.showGraphic(firstLineChart, FUNCTION, PERIOD, N, "Исходный");
//
//            Complex discreteFourierTransformResult[] = FourierFunctions.getDiscreteFourierTransform(FUNCTION, PERIOD, N);
//            Complex fastFourierTransformResult[] = FourierFunctions.getFastFourierTransform(FUNCTION, PERIOD, N);
//
//            GraphicsCreator.showGraphic(secondLineChart, discreteFourierTransformResult, "Прямое ДПФ");
//            GraphicsCreator.showGraphic(thirdLineChart, discreteFourierTransformResult, "Прямое ДПФ2");
//
//            GraphicsCreator.showGraphic(fourthLineChart, fastFourierTransformResult, "Прямое БПФ");
//            GraphicsCreator.showGraphic(fifthLineChart, fastFourierTransformResult, "Прямое БПФ");
//
////            System.out.println("C["+i+"]=("+discreteFourierTransformResult[i].abs()+", " + discreteFourierTransformResult[i].phase() + ")");
//            System.out.println("-----Дискретное-----");
//            for(int i = 0; i < N; i++) {
////                System.out.println("C["+i+"]="+discreteFourierTransformResult[i]);
//                System.out.println("C["+i+"]=("+discreteFourierTransformResult[i].abs()+", " + discreteFourierTransformResult[i].phase() + ")");
//            }
//            System.out.println("-----Быстре-----");
//            for(int i = 0; i < N; i++) {
////                System.out.println("C["+i+"]="+fastFourierTransformResult[i]);
//                System.out.println("C["+i+"]=("+fastFourierTransformResult[i].abs()+", " + fastFourierTransformResult[i].phase() + ")");
//            }
//            System.out.println("------Разница------");
//            for(int i = 0; i < N; i++) {
////                System.out.println("C["+i+"]="+discreteFourierTransformResult[i].minus(fastFourierTransformResult[i]));
//                System.out.println("C["+i+"]=("+(discreteFourierTransformResult[i].abs()- fastFourierTransformResult[i].abs())+", " + (discreteFourierTransformResult[i].phase() - fastFourierTransformResult[i].phase()) + ")");
//            }
//        });
    }
}
