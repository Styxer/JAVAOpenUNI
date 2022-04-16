package com.example.q2;

import javafx.scene.shape.Circle;

import static com.example.q2.Constants.*;


//Represent a game disc on the board
public class Discit extends Circle {
    private final boolean _isFirstPlayerTurn;

    public Discit(boolean isFirstPlayerTurn) {
        super(TILE_SIZE / 2, isFirstPlayerTurn ? FIRST_PLAYER_COLOR : SECOND_PLAYER_COLOR);
        this._isFirstPlayerTurn = isFirstPlayerTurn;

        setCenterX(TILE_SIZE / 2);
        setCenterY(TILE_SIZE / 2);
    }

    public boolean getIsFirstPlayerTurn() {
        return _isFirstPlayerTurn;
    }

    @Override
    public String toString() {
        return super.toString() + "Discit{" +
                "_isFirstPlayerTurn=" + _isFirstPlayerTurn +
                '}';
    }
}
