package com.zesy.cosi.labs.lab1;

import com.zesy.cosi.labs.Complex;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class GraphicsGreater {

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
        xs[0] = 0;
        for (int i = 1; i < xs.length; i++) {
            xs[i] = xs[i - 1] + period;
        }

        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < ys.length; i++) {
            series.getData().add(new XYChart.Data(xs[i], ys[i]));
        }
        lineChart.getData().add(series);
    }
}
