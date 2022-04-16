package com.example.q2;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.Optional;

public class Disc{
    private Circle _point;
    private boolean _isAvailable;
    private boolean _isRedTurn;

    private  Disc[][] _grid;

    public Disc(boolean isRedTurn) {
       // super(80/ 2, isRedTurn ? Color.RED : Color.GREEN);
       // _point = point;
       // _isRedTurn = isRedTurn;

       // setCenterX(40);
        //setCenterY(40);

    }

    public boolean getIsAvailable() {
        return _isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this._isAvailable = isAvailable;
    }

    public boolean getIsRedTurn() {
        return _isRedTurn;
    }

    public void setIsRedTurn(boolean isRedTurn) {
        this._isRedTurn = isRedTurn;
    }

    public static Optional<Disc> getDisc(Disc[][] grid, int column, int row) {
        if (column < 0 || column >= 7
                || row < 0 || row >= 6)
            return Optional.empty();

        return Optional.ofNullable(grid[column][row]);
    }


}
