package com.zesy.cosi.labs;

public class Complex {
    private static int minusCounter = 0;
    private static int multiplyCounter = 0;
    private static int plusCounter = 0;

    private final double re;
    private final double im;

    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im < 0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    public double abs() {
        return Math.hypot(re, im);
    }

    public double phase() {
        return Math.atan(im / re);
    }

    public Complex plus(Complex b) {
        plusCounter++;
        Complex a = this;
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }

    public Complex minus(Complex b) {
        minusCounter++;
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    public Complex times(Complex b) {
        multiplyCounter++;
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }

    public Complex times(double alpha) {
        return new Complex(alpha * re, alpha * im);
    }

    public Complex conjugate() {
        return new Complex(re, -im);
    }

    public Complex reciprocal() {
        double scale = re * re + im * im;
        return new Complex(re / scale, -im / scale);
    }

    public Complex divides(Complex b) {
        Complex a = this;
        return a.times(b.reciprocal());
    }

    public Complex divides(int param) {
        return new Complex(this.re / param, this.im / param);
    }

    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    public Complex sin() {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    public Complex cos() {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    public Complex tan() {
        return sin().divides(cos());
    }

    public static Complex plus(Complex a, Complex b) {
        plusCounter++;
        double real = a.re + b.re;
        double imag = a.im + b.im;
        Complex sum = new Complex(real, imag);
        return sum;
    }

    public double re() {
        return re;
    }

    public double im() {
        return im;
    }

    public static int getMinusCounter() {
        return minusCounter;
    }

    public static int getMultiplyCounter() {
        return multiplyCounter;
    }


    public static int getPlusCounter() {
        return plusCounter;
    }

    public static void nullifyAllCounters() {
        minusCounter = 0;
        plusCounter = 0;
        multiplyCounter = 0;
    }
}