package com.example.q2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import static com.example.q2.Constants.*;

public class HelloController {


    @FXML
    private Button clearBtn;

    @FXML
    private Pane pane;

    @FXML
    private Label lbl;



    private Discit[][] grid;


    private IBoard _gameBoard;



    public  void initialize(){
        initNewGame();

    }

    //  Resets the board to  a new game state
    @FXML
    void Clear(ActionEvent event) {

        _gameBoard.setIsGameOver(false);
        initialize();

    }

    //initialize new game
    private  void initNewGame(){
        _gameBoard = new GameBoard(lbl);
        grid = new Discit[COLUMNS][ROWS];
        pane.getChildren().clear();


        pane.getChildren().add(_gameBoard.createGrid());

        pane.getChildren().add(_gameBoard.getDiscRoot());
        pane.getChildren().addAll(_gameBoard.addClickLitsner());
    }

}