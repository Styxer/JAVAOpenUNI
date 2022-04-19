package com.example.q1;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

//Represents a drawing board
public class DrawingBoard implements IBoard{

    private Point2D _startPoint, _endPoint;
    private Color _selectedColor;
    private FillType _fillType;

    public Color getSelectedColor() {
        return _selectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        _selectedColor = selectedColor;
    }

    public FillType getFillType() {
        return _fillType;
    }

    public void setFillType(FillType fillType) {
        _fillType = fillType;
    }

    public Point2D getStartPoint() {
        return _startPoint;
    }

    public void setStartPoint(Point2D startPoint) {
        this._startPoint = startPoint;
    }

    public Point2D getEndPoint() {
        return _endPoint;
    }

    public void setEndPoint(Point2D endPoint) {
        _endPoint = endPoint;
    }

    //create and return a polygon(circle, rectangle or line)
    @Override
    public Shape createPolygon(Polygon polygon) {
        Shape shape = null;
        if(polygon == Polygon.RECTANGLE){
            shape =  createRectangle();
        }else if(polygon == Polygon.CIRCLE){
            shape =  createCircle();
        }else if(polygon == Polygon.LINE){
            shape = createLine();
        }
        Helpers.fillShape(shape,_selectedColor,polygon, _fillType);
        return shape;
    }

    //create a new circle
    private Shape createCircle(){
        return new MyCircle(_startPoint, _endPoint);
    }

    //create a new line
    private Shape createLine(){
        return new MyLine(_startPoint.getX(),_startPoint.getY(), _startPoint.getX(),_startPoint.getY(), _endPoint);
    }

    //create a new rectangle
    private Shape createRectangle(){
        return new  MyRectangle(0,0,0,0,_startPoint,_endPoint);
    }
}
