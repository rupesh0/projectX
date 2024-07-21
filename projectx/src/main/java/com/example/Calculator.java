package com.example;

import static java.lang.Double.NaN;
import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Calculator {

    public enum BiOperatorModes {
        normal, add, minus, multiply, divide , xpowerofy 
    }

    public enum MonoOperatorModes {
        square, squareRoot, oneDividedBy, cos, sin, tan, log, rate, abs, ln,
    }

    private Double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.normal;

    private Double calculateBiImpl() {
        if (mode.equals(BiOperatorModes.normal)) {
            return num2;
        }
        if (mode.equals(BiOperatorModes.add)) {
            if (num2 != 0) {
                return num1 + num2;
            }

            return num1;
        }
        if (mode.equals(BiOperatorModes.minus)) {
            return num1 - num2;
        }
        if (mode.equals(BiOperatorModes.multiply)) {
            return num1 * num2;
        }
        if (mode.equals(BiOperatorModes.divide)) {
            return num1 / num2;
        }
        if (mode.equals(BiOperatorModes.xpowerofy)) {
            return pow(num1,num2);
        }

        // never reach
        throw new Error();
    }

    public Double calculateBi(BiOperatorModes newMode, Double num) {
        if (mode.equals(BiOperatorModes.normal)) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.normal, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.normal;

        return NaN;
    }

    
    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        if (newMode.equals(MonoOperatorModes.square)) {
            return num * num;
        }
        if (newMode.equals(MonoOperatorModes.squareRoot)) {
            return Math.sqrt(num);
        }
        if (newMode.equals(MonoOperatorModes.oneDividedBy)) {
            return 1 / num;
        }
        if (newMode.equals(MonoOperatorModes.cos)) {
            return Math.cos(num);
        }
        if (newMode.equals(MonoOperatorModes.sin)) {
            return Math.sin(num);
        }
        if (newMode.equals(MonoOperatorModes.tan)) {
            if (num == 0 || num % 180 == 0 ) {
                return 0.0;
            }
            if (num % 90 == 0.0 && num % 180 != 0.0) {
                return NaN;
            }

            return Math.tan(num);
        }
        if (newMode.equals(MonoOperatorModes.log)) {
            return log10(num);
        }
        if (newMode.equals(MonoOperatorModes.ln)) {
            return log(num);
        }
        if (newMode.equals(MonoOperatorModes.rate) ) {
            return num / 100;
        }
        if (newMode.equals(MonoOperatorModes.abs)){
            return Math.abs(num);
        }

        // never reach
        throw new Error();
    }

}
