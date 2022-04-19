package com.example.q1;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

//represent a general board
public interface IBoard {
     Shape createPolygon(Polygon polygon);
     Point2D getStartPoint();
     void setStartPoint(Point2D startPoint);
     Point2D getEndPoint();
     void setEndPoint(Point2D endPoint);

     void setSelectedColor(Color selectedColor);
     void setFillType(FillType fillType);

}
