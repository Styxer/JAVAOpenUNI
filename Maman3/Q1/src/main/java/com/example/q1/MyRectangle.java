package com.example.q1;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyRectangle extends Rectangle {

    public MyRectangle(double v, double v1, double v2, double v3 , Point2D startPoint, Point2D endPoint, Color selectedColor, FillType fillType) {
        super(v, v1, v2, v3);

        this.setTranslateX(startPoint.getX());
        this.setTranslateY(startPoint.getY());

        this.setWidth(endPoint.getX() - this.getTranslateX());
        this.setHeight(endPoint.getY() - this.getTranslateY());

        Helpers.fillShape(this, selectedColor,Polygon.RECTANGLE, fillType);
    }
}
