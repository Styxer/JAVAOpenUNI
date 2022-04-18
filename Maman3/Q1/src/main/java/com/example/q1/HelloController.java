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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
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

    public  void initialize(){
        _polygon = Polygon.RECTANGLE;
        _fillType = FillType.EMPTY;
        _shapes = new Stack<>();


    }

    @FXML
    void mouseDrag(MouseEvent event) {
        _isDragged = true;
    }

    @FXML
    void mousePressed(MouseEvent event) {
        _startPoint = new Point2D(event.getX(), event.getY());
    }

    @FXML
    void mouseRelased(MouseEvent event) {
        if(_isDragged){
            _endPoint = new Point2D(event.getX(), event.getY());
            if(_polygon == Polygon.RECTANGLE){
                createRectangle();
            }else if(_polygon == Polygon.CIRCLE){
                createCircle();
            }else if(_polygon == Polygon.LINE){
                createLine();
            }
        }
    }

    private void createLine(){
        Line line = new Line(_startPoint.getX(),_startPoint.getY(), _startPoint.getX(),_startPoint.getY());
        line.setEndX(_endPoint.getX());
        line.setEndY(_endPoint.getY());

        fillShape(line);
        addShapeToScreen(line);
    }

    private void createCircle(){
        Circle circle = new Circle();
        circle.setCenterX(_startPoint.getX());
        circle.setCenterY(_endPoint.getY());
        double radius = Math.sqrt(Math.pow(_startPoint.getX() - _endPoint.getX(), 2) +
                Math.pow(_startPoint.getY() - _endPoint.getY(), 2));
        circle.setRadius(radius);

        fillShape(circle);
        addShapeToScreen(circle);
    }


    private void createRectangle(){
        MyRectangle rectangle = new MyRectangle(0,0,0,0,_startPoint,_endPoint, colorPicker.getValue(),_fillType);
//        Rectangle rectangle = new Rectangle(0,0,0,0);
//        rectangle.setTranslateX(_startPoint.getX());
//        rectangle.setTranslateY(_startPoint.getY());
//
//        rectangle.setWidth(_endPoint.getX() - rectangle.getTranslateX());
//        rectangle.setHeight(_endPoint.getY() - rectangle.getTranslateY());
//
//        fillShape(rectangle);
        addShapeToScreen(rectangle);
    }

    private void addShapeToScreen(Shape shape){
        pane.getChildren().add(shape);
        _shapes.add(shape);
    }

    private void fillShape(Shape shape){
        var selectedColor = colorPicker.getValue();
        if(_polygon == Polygon.LINE){
            shape.setStroke(selectedColor);
        }else {
            if(_fillType == FillType.EMPTY ){
                shape.setFill(Color.TRANSPARENT);
                shape.setStroke(selectedColor);
            }else{
                shape.setFill(selectedColor);
            }
        }

    }

    //

    @FXML
    void onActionCircleSelect(ActionEvent event) {
        _polygon = Polygon.CIRCLE;
    }

    @FXML
    void onActionClear(ActionEvent event) {
        pane.getChildren().clear();
    }

    @FXML
    void onActionColorPicker(ActionEvent event) {

    }

    @FXML
    void onActionEmptyShape(ActionEvent event) {
        _fillType = FillType.EMPTY;
    }

    @FXML
    void onActionFullShape(ActionEvent event) {
        _fillType = FillType.FULL;
    }

    @FXML
    void onActionLineSelect(ActionEvent event) {
        _polygon = Polygon.LINE;
    }

    @FXML
    void onActionRectangleSelect(ActionEvent event) {
        _polygon = Polygon.RECTANGLE;
    }

    @FXML
    void onActionUndo(ActionEvent event) {
        if(_shapes.size() > 0){
            Shape shape =  _shapes.pop();
            pane.getChildren().remove(shape);
        }
    }

}
