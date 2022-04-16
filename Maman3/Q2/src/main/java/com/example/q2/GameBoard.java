package com.example.q2;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.q2.Constants.*;

//Represent a game board, each can "hold" zero or one discits
public class GameBoard implements  IBoard {
    private final Discit[][] _grid;
    private boolean _isFirstPlayerMove, _isGameOver;
    private final Pane _discRoot;
    private final Label _lbl;
    private final List<Circle> _circles;

    public GameBoard(Label lbl) {
        _grid =  new Discit[COLUMNS][ROWS];
        _isFirstPlayerMove = true;
        _discRoot =  new Pane();
        _lbl = lbl;
        _lbl.setText("First Player Turn");
        _circles = new ArrayList<>();
    }

    public Discit[][] getGrid() {
        return _grid;
    }

    public Label getLbl() {
        return _lbl;
    }

    public boolean getIsFirstPlayerMove() {
        return _isFirstPlayerMove;
    }

    public void setFirstPlayerMove(boolean firstPlayerMove) {
        _isFirstPlayerMove = firstPlayerMove;
    }

    public Pane getDiscRoot() {
        return _discRoot;
    }

    public boolean getIsGameOver() {
        return _isGameOver;
    }

    public void setIsGameOver(boolean isGameOver) {
        _isGameOver = isGameOver;
    }

    //Draw an empty game grid on the screen
    public Shape createGrid() {
        Shape shape = new Rectangle((COLUMNS + 1) * TILE_SIZE, (ROWS + 1) * TILE_SIZE);

        for (int y = 0; y < ROWS; y++) {
            for (int x = 0; x < COLUMNS; x++) {
                Circle circle = new Circle(TILE_SIZE / 2, EMPTY_COLOR);
                circle.setCenterX(TILE_SIZE / 2);
                circle.setCenterY(TILE_SIZE / 2);
                circle.setTranslateX(x * (TILE_SIZE + 5) + TILE_SIZE / 4);
                circle.setTranslateY(y * (TILE_SIZE + 5) + TILE_SIZE / 4);
                _circles.add(circle);

                shape = Shape.subtract(shape, circle);
            }
        }

        shape.setFill(Color.PURPLE);


        return shape;
    }

    //add event litsners to the game board
    public List<Circle> addClickLitsner() {
        List<Rectangle> list = new ArrayList<>();

        for (int x = 0; x < COLUMNS; x++) {
            final int column = x;
            addOnMouseEntered(column);
            addOnMouseExited(column);
            addOnMouseClicked(column);
        }

        return _circles;
    }

    //add mouse entered event to show current insert row(like a hint)(only apply to top level row like real life game)
    private  void addOnMouseEntered(int column){
        _circles.get(column).setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                _circles.get(column).setFill(HINT_COLOR);
            }
        });
    }

    //add mouse exited event to remove the hint when mouse leave the cell
    private  void addOnMouseExited(int column){
        _circles.get(column).setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                _circles.get(column).setFill(EMPTY_COLOR);
            }
        });
    }

    //add mouse click event
    private void addOnMouseClicked(int column){
        _circles.get(column).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(!_isGameOver){
                    placeDiscit(new Discit(_isFirstPlayerMove), column);
                }
            }
        });
    }

    //place a discit in the game board
    public void placeDiscit(Discit disc, int column) {
        int row = ROWS - 1;
        do {
            if (!getDisc(column, row).isPresent())
                break;

            row--;
        } while (row >= 0);

        if (row < 0)
            return;

        _grid[column][row] = disc;
        _discRoot.getChildren().add(disc);
        disc.setTranslateX(column * (TILE_SIZE + 5) + TILE_SIZE / 4);
        disc.setTranslateY(row * (TILE_SIZE + 5) + TILE_SIZE / 4);
        final int currentRow = row;
        if (gameEnded(column, currentRow)) {
            printGameOver();
            _isGameOver = true;
        }
        else {
            printPlayerTurn();
        }

        _isFirstPlayerMove = !_isFirstPlayerMove;

    }

    //checks if disc in at a current position if not return null
    private Optional<Discit> getDisc(int column, int row) {
        if (column < 0 || column >= COLUMNS
                || row < 0 || row >= ROWS)
            return Optional.empty();

        return Optional.ofNullable(_grid[column][row]);
    }

    //check if game has ended by checking all directions
    private boolean gameEnded(int column, int row) {
        List<Point2D> vertical = new ArrayList<>();
        for (int i = row -3 ; i <= row +3 ; i++) {
            vertical.add(new Point2D(column, i));
        }

        List<Point2D> horizontal  = new ArrayList<>();
        for (int i = column -3 ; i <= column +3 ; i++) {
            horizontal.add(new Point2D(i, row));
        }

        Point2D topLeft = new Point2D(column - 3, row - 3);
        List<Point2D> diagonal1 = new ArrayList<>();
        diagonal1.add(new Point2D(column - 3, row -3));
        for (int i = 1; i <= 6; i++) {
            diagonal1.add(new Point2D(topLeft.getX() + i,topLeft.getY() + i));
        }


        List<Point2D> diagonal2 = new ArrayList<>();
        Point2D bottomLeft = new Point2D(column - 3, row + 3);
        diagonal2.add(bottomLeft);
        for (int i = 1; i <= 6; i++) {
            diagonal2.add(new Point2D(bottomLeft.getX() + i,bottomLeft.getY() - i));
        }

        return checkRange(vertical) || checkRange(horizontal)
                || checkRange(diagonal1) || checkRange(diagonal2);
    }

    //checking if in a certain range(ex. horizontal) a game winning condition has met
    private boolean checkRange(List<Point2D> points) {
        int chain = 0;

        for (Point2D p : points) {
            int column = (int) p.getX();
            int row = (int) p.getY();

            Discit disc = getDisc(column, row).orElse(new Discit(!_isFirstPlayerMove));
            if (disc.getIsFirstPlayerTurn() == _isFirstPlayerMove) {
                if (++chain == AMOUNT_TO_WIN) {
                    return true;
                }
            } else {
                chain = 0;
            }
        }

        return false;
    }

    //print game over message to the screen
    private void printGameOver() {
        _lbl.setText("Winner: " + (_isFirstPlayerMove ? "First Player Won" : "Second Player Won"));
    }

    //print current player turn to the screen
    private void printPlayerTurn(){
        _lbl.setText(_isFirstPlayerMove ? "First Player Turn" : "Second Player Turn");
    }
}
