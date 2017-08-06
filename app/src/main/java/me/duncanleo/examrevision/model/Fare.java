package me.duncanleo.examrevision.model;

/**
 * Created by duncanleo on 6/8/17.
 */

public class Fare {
    private String title;
    private double normal;
    private double limo;
    private double chrysler;

    public Fare(String title, double normal, double limo, double chrysler) {
        this.title = title;
        this.normal = normal;
        this.limo = limo;
        this.chrysler = chrysler;
    }

    public String getTitle() {
        return title;
    }

    public double getNormal() {
        return normal;
    }

    public double getLimo() {
        return limo;
    }

    public double getChrysler() {
        return chrysler;
    }
}
