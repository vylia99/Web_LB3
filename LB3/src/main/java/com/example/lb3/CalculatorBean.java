package com.example.lb3;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;

@Named
@SessionScoped
@Data
public class CalculatorBean implements Serializable {
    private double x;
    private double a;
    private double b;
    private double c;
    private double start;
    private double end;
    private double step;
    private double functionY;
    private int count;
    private double[] masX;
    private double[] masY;
    private int imin;
    private int imax;
    private double min;
    private double max;
    private double sum;
    private double average;



    public String calculate() {
        Main main = new Main();


        double[] masX = main.createArrayX(start, end, step);
        double[] masY = main.createArrayY(a, b, c, masX);
        imin = main.iminY(masY);
        min = masY[imin];
        imax = main.imaxY(masY);
        max = masY[imax];
        sum = main.sumY(masY);
        average = main.averageY(masY);

        return "result";
    }
    public String getMinStr(){
        return "%6.3f".formatted(min);
    }
    public String getMaxStr(){
        return "%6.3f".formatted(max);
    }
    public String getSumStr(){
        return "%6.3f".formatted(sum);
    }
    public String getAverageStr(){
        return "%6.3f".formatted(average);
    }
}
