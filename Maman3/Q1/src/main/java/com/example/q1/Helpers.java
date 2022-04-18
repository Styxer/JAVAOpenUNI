package com.example.q1;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Helpers {
    public static Shape fillShape(Shape shape, Color selectedColor, Polygon polygon, FillType fillType){
        //var selectedColor = colorPicker.getValue();
        if(polygon == Polygon.LINE){
            shape.setStroke(selectedColor);
        }else {
            if(fillType == FillType.EMPTY ){
                shape.setFill(Color.TRANSPARENT);
                shape.setStroke(selectedColor);
            }else{
                shape.setFill(selectedColor);
            }
        }
        return  shape;

    }
}
