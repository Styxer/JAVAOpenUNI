package com.example.q1;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

//represent a Line that is drawn from mouse drag start and end
public class MyLine extends Line {
    public MyLine(double v, double v1, double v2, double v3, Point2D endPoint) {
        super(v, v1, v2, v3);
        this.setEndX(endPoint.getX());
        this.setEndY(endPoint.getY());

    }
}
