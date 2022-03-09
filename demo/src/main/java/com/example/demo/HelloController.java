package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.Random;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Canvas canv;

    private GraphicsContext gc;

    public  void initialize(){
        gc = canv.getGraphicsContext2D();
    }

    @FXML
    void btnPressed(ActionEvent event){
//        gc.setFill(Color.RED);
//        gc.fillRect(10,10,300,400);

        gc.clearRect(0,0,canv.getWidth(),canv.getHeight());
        final  int SIZE = 10;
        Random r = new Random();
        for (int i =0; i < SIZE ; i++){
            int x = r.nextInt(300);
            int y = r.nextInt(300);

            int w = r.nextInt(300);
            int h = r.nextInt(300);

            gc.setFill(Color.color(Math.random(),Math.random(),Math.random()));
            gc.fillOval(x,y,w,h);
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}