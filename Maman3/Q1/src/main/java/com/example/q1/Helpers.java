package com.example.q1;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

//Helper Functions
public class Helpers {
    //setting  shape fill - FULL or EMPTY
    public static Shape fillShape(Shape shape, Color selectedColor, Polygon polygon, FillType fillType){
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
