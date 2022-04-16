package com.example.q2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Canvas canv;

    @FXML
    private Button clearBtn;

    @FXML
    private Pane pane;

    private GraphicsContext gc;
    private int height , width ;
    private  int pixelWidth, pixelHiegth;
    private static final int TILE_SIZE = 80;
    private static final int COLUMNS = 7;
    private static final int ROWS = 6;

    ArrayList<Shape> _shapes;
    Shape shape;
    Color currentPlayerColor;
    Disc[][] _grid;



    public  void initialize(){

        _shapes = new ArrayList<>();
        _grid = new Disc[ROWS][COLUMNS];
        makeGrid();
        createClick();
        pane.getChildren().add(shape);
        pane.getChildren().addAll(_shapes);
        currentPlayerColor = Color.RED;

        //pane.getChildren().addAll(createClick());



    }

    @FXML
    void Clear(ActionEvent event) {

        System.out.println("fdfsd");
    }

    @FXML
    void Click(MouseEvent event) {


    }

    private void makeGrid() {
        shape = new Rectangle((COLUMNS + 1) * TILE_SIZE, (ROWS + 1) * TILE_SIZE);
        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLUMNS; y++) {
                Circle circle = new Circle(TILE_SIZE / 2);
                circle.setCenterX(TILE_SIZE / 2);
                circle.setCenterY(TILE_SIZE / 2);
                circle.setTranslateX(y * (TILE_SIZE + 5) + TILE_SIZE / 4);
                circle.setTranslateY(x * (TILE_SIZE + 5) + TILE_SIZE / 4);
                circle.setFill(Color.TRANSPARENT);

                shape = Shape.subtract(shape, circle);
                _shapes.add(circle);

                _grid[x][y] = new Disc(true);
            }
        }

        shape.setFill(Color.PINK);
        //return shape;
    }

    private void createClick(){

        for (int i = 0; i < _shapes.size(); i++) {
            int finalI = i;
            _shapes.get(i).setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    handleMouse(finalI,Color.ORANGE);
                }
            });

            _shapes.get(i).setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    handleMouse(finalI,Color.TRANSPARENT);
                }
            });
            _shapes.get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if(finalI < COLUMNS)
                        placeDisc(finalI);
                }
            });
        }
    }

    private void handleMouse(int index, Color color){
        if(!_shapes.get(index).getFill().equals(Color.RED) && !_shapes.get(index).getFill().equals(Color.GREEN) && index < COLUMNS){
            _shapes.get(index).setFill(color);
        }
    }

    void placeDisc(int column){
        int row = 0 ;

        while (!_grid[row][column].getIsAvailable() && row < ROWS - 1){
            row++;
        }


        if(_grid[row][column].getIsAvailable())
            row--;
        int indexToFilInArr = row *  COLUMNS + column;
        _grid[row][column].setIsRedTurn(getCurrentTurn());
        _grid[row][column].setIsAvailable(true);


        _shapes.get(indexToFilInArr).setFill(currentPlayerColor);
        checkGameOver(row, column);
        setPlayerColor();
    }

    private  void setPlayerColor(){
        Color color = currentPlayerColor == Color.RED ? Color.GREEN : Color.RED;
        currentPlayerColor = color;
    }

    private  boolean getCurrentTurn() {
        return currentPlayerColor == Color.RED;
    }

    private  boolean checkGameOver(int row, int column){


        boolean result = false;
        boolean isRedTurn = getCurrentTurn();
        int chain = 0;
        //horizontally
        if(row - 4 <= ROWS){
            for (int i = 0; i < 4; i++) {
                if(_grid[row - i][column].getIsRedTurn() == isRedTurn){
                    chain++;
                }
                if(chain == 4)
                    result =  true;

            }
        }

        return result;


    }


}