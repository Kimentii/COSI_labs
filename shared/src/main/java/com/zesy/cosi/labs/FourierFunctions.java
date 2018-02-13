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

        System.out.println("-");
        System.out.println("----");
        System.out.println("-------");
        System.out.println("----------");
        System.out.println("-------------");
        System.out.println("----------");
        System.out.println("-------");
        System.out.println("----");
        System.out.println("-");


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

        for (int i = 0; i < N; i++) {

        }
        for (int k = 0; k < N; k++) {
            for (int m = 0; m < N; m++) {
                Complex a = new Complex(cos(m * k * ((double) period) / N), -sin(m * k * ((double) period / N)));
                double x = function.apply(period * ((double) m) / N);
//                System.out.println("result["+k+"]+=a("+a+")*x("+x+")="+a.times(x));
                result[k] = result[k].plus((a.times(x)).divides(N));
            }
        }
        return result;
    }

    public static Complex[] getFastFourierTransform(Function<Double, Double> function, double period, int N) {
        return null;
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

//    private static Complex[] commonDiscreteFourierTransformation(Complex[] values, float period, int N, boolean reverse) {
//        Complex[] result = new Complex[N];
//        for (int i = 0; i < N; i++) {
//            result[i] = new Complex(0, 0);
//        }
//        for (int k = 0; k < N; k++) {
//            for (int i = 0; i < N; i++) {
//                Complex a = new Complex(cos(period * k * ((double)i)/N), -sin(period * k * ((double)i/N)));
//                Complex x = new Complex(function.apply(period * ((double)k)/N));
////                System.out.println("result["+k+"]+=a("+a+")*x("+x+")");
//                result[k] = result[k].plus(a.times(x));
//            }
//        }
//        return result;
//    }
}
