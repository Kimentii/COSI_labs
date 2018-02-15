package com.zesy.cosi.labs;

import java.util.function.Function;

import static java.lang.Math.*;

/**
 * Implements functions for Fourier transformation.
 *
 * @author zoxal
 * @version 13/02/18
 */
public class FourierFunctions {
    public static void main(String[] args) {
//        System.out.println(cos(-2*PI/3));
//        System.out.println(sin(-2*PI/3));

        Complex[] a = getDiscreteFourierTransform((x) -> sin(6 * x) + cos(5 * x), 2 * PI, 32);
        for (Complex c : a) {
            System.out.println(c);
        }
    }

    /**
     * Calculates discrete Fourier transformation.
     *
     * @param function function to transform
     * @param period   period of function
     * @param N        amount of points
     * @return array of {@link Complex} numbers, representing phase graph
     */
    public static Complex[] getDiscreteFourierTransform(Function<Double, Double> function, double period, int N) {
        Complex[] result = new Complex[N];
        for (int i = 0; i < N; i++) {
            result[i] = new Complex(0, 0);
        }

        for (int k = 0; k < N; k++) {
            for (int n = 0; n < N; n++) {
                Complex a = new Complex(cos(period * k * ((double) n) / N), -sin(period * k * ((double) n / N)));
                double x = function.apply(period * ((double) n) / N);
                result[k] = result[k].plus(a.times(x));
            }
            result[k] = result[k].divides(N);
        }
        return result;
    }

    public static Complex[] getFastFourierTransform(Function<Double, Double> function, double period, int N) {
        Complex[] source = new Complex[N];
        for (int i = 0; i < N; i++) {
            source[i] = new Complex(function.apply(period * (double) i / N));
        }
        Complex[] result = getFastFourierTransformRecursive(source, period);

        for (int i = 0; i < N; i++) {
            result[i] = result[i].divides(N);
        }
        return result;
    }

    public static double[] getReverseFourierTransform(Complex[] values, double period, int N) {
        double X[] = new double[N];
        for (int i = 0; i < N; i++) {
            X[i] = 0;
        }
        for (int m = 0; m < N; m++) {
            for (int k = 0; k < N; k++) {
                Complex W2 = new Complex(cos((-2 * PI) / N * (-m * k)), sin((-2 * PI) / N * (-m * k)));
                X[m] += (values[k].times(W2)).re();
            }
        }
        return X;

    }

    private static Complex[] getFastFourierTransformRecursive(Complex[] sourceArray, double period) {
        if (sourceArray.length == 1) return sourceArray;
        Complex evenArray[] = new Complex[sourceArray.length / 2];
        Complex oddArray[] = new Complex[sourceArray.length / 2];
        for (int i = 0; i < sourceArray.length; i++) {
            if (i % 2 == 0) {
                oddArray[i / 2] = sourceArray[i];
            } else {
                evenArray[i / 2] = sourceArray[i];
            }
        }
        Complex[] evenResult = getFastFourierTransformRecursive(evenArray, period);
        Complex[] oddResult = getFastFourierTransformRecursive(oddArray, period);
        Complex[] result = new Complex[sourceArray.length];
        Complex Wn = new Complex(cos(period / sourceArray.length), sin(period / sourceArray.length));
        Complex w = new Complex(1);
        for (int i = 0; i < sourceArray.length / 2; i++) {
            result[i] = evenResult[i].plus(w.times(oddResult[i]));
            result[i + sourceArray.length / 2] = evenResult[i].minus(w.times(oddResult[i]));
            w = w.times(Wn);
        }
        return result;
    }
}
