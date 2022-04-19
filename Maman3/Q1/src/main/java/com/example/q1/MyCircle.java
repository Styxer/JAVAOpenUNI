package com.example.q1;

import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

//represent a circle that is drawn from mouse drag start and end
public class MyCircle extends Circle {

    public MyCircle(Point2D startPoint, Point2D endPoint) {
        super();
        this.setCenterX(startPoint.getX());
        this.setCenterY(endPoint.getY());
        double radius = Math.sqrt(Math.pow(startPoint.getX() - endPoint.getX(), 2) +
                Math.pow(startPoint.getY() - endPoint.getY(), 2));
        this.setRadius(radius);
    }
}
