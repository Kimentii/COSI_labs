package com.zesy.cosi.labs.lab1;

import com.zesy.cosi.labs.Complex;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.function.Function;

public class GraphicsCreator {

    public static void showGraphic(LineChart<Number, Number> lineChart, Complex[] values) {
        lineChart.setTitle("Title");

        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < values.length; i++) {
            series.getData().add(new XYChart.Data(values[i].phase(), values[i].abs()));
        }
        lineChart.getData().add(series);
    }

    public static void showGraphic(LineChart<Number, Number> lineChart, double[] ys, double period) {
        double[] xs = new double[ys.length];
        for (int i = 0; i < xs.length; i++) {
            xs[i] = period * (double) i / xs.length;
        }

        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < ys.length; i++) {
            series.getData().add(new XYChart.Data(xs[i], ys[i]));
        }
        lineChart.getData().add(series);
    }

    public static void showGraphic(LineChart<Number, Number> lineChart, Function<Double, Double> function, double period, int N) {
        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < N; i++) {
            series.getData().add(new XYChart.Data(period * (double) i / N,
                    function.apply(period * (double) i / N)));
        }
        lineChart.getData().add(series);
    }
}
