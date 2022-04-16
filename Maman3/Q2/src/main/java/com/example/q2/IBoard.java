package com.example.q2;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.List;


//represent a general inference for a board
public interface IBoard {
    List<Circle> addClickLitsner();
    Shape createGrid();
    Pane getDiscRoot();
    void setIsGameOver(boolean isGameOver);
}
