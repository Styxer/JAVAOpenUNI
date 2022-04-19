package com.example.q1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.util.*;

public class HelloController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnUndo;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private ToggleGroup grpShapes;

    @FXML
    private Pane pane;

    @FXML
    private RadioButton radioBtnCircle;

    @FXML
    private RadioButton radioBtnEmptyShape;

    @FXML
    private RadioButton radioBtnFullShape;

    @FXML
    private RadioButton radioBtnLine;

    @FXML
    private RadioButton radioBtnRectangle;

    @FXML
    private ToggleGroup shapeFillGrp;

     private Point2D _startPoint, _endPoint;
     private boolean _isDragged;
     private Polygon _polygon;
     private FillType _fillType;
     private Stack<Shape> _shapes;
     private IBoard _board;

    public  void initialize(){
        _polygon = Polygon.RECTANGLE;
        _fillType = FillType.EMPTY;
        _shapes = new Stack<>();
        _board = new DrawingBoard();
    }

    //mouse drag
    @FXML
    void mouseDrag(MouseEvent event) {
        _isDragged = true;
    }

    //mouse pressed
    @FXML
    void mousePressed(MouseEvent event) {
        _startPoint = new Point2D(event.getX(), event.getY());
    }

    //mouse released
    @FXML
    void mouseRelased(MouseEvent event) {
        if(_isDragged){
            _endPoint = new Point2D(event.getX(), event.getY());
            _board.setStartPoint(_startPoint);
            _board.setEndPoint(_endPoint);
            _board.setFillType(_fillType);
            _board.setSelectedColor(colorPicker.getValue());
            Shape shape = _board.createPolygon(_polygon);
            addShapeToScreen(shape);

        }
    }

    //add shape to the screen
    private void addShapeToScreen(Shape shape){
        pane.getChildren().add(shape);
        _shapes.add(shape);
    }

    //upon selecting a Circle
    @FXML
    void onActionCircleSelect(ActionEvent event) {
        _polygon = Polygon.CIRCLE;
    }

    //clear all shapes from the screen
    @FXML
    void onActionClear(ActionEvent event) {
        pane.getChildren().clear();
    }

    @FXML
    void onActionColorPicker(ActionEvent event) {

    }

    ////upon selecting an empty shape fill
    @FXML
    void onActionEmptyShape(ActionEvent event) {
        _fillType = FillType.EMPTY;
    }

    ////upon selecting a full shape fill
    @FXML
    void onActionFullShape(ActionEvent event) {
        _fillType = FillType.FULL;
    }

    //upon selecting a Line
    @FXML
    void onActionLineSelect(ActionEvent event) {
        _polygon = Polygon.LINE;
    }

    //upon selecting a Rectangle
    @FXML
    void onActionRectangleSelect(ActionEvent event) {
        _polygon = Polygon.RECTANGLE;
    }

    //remove last inserted shape from screen
    @FXML
    void onActionUndo(ActionEvent event) {
        if(_shapes.size() > 0){
            Shape shape =  _shapes.pop();
            pane.getChildren().remove(shape);
        }
    }
}
