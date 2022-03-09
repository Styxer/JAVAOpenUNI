package com.example.q2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class HelloController {

    @FXML
    private Canvas canv;

    private GraphicsContext gc;

    private final int PIXEL_WIDTH = 10;
    private Random random;
    private int percentage;

    private int height , width ;


    public  void initialize(){

        gc = canv.getGraphicsContext2D();

        gc.setLineWidth(1);
        gc.setFill(Color.BLACK);
        random = new Random();


        height = (int)canv.getHeight();
        width = (int)canv.getWidth();

        percentage =  (height  * width) / PIXEL_WIDTH;

    }

    //created new random canvas with matrix that's 10% of it are fill with black "boxes"
    @FXML
    void btnPressed(ActionEvent event){
        gc.clearRect(0,0,canv.getWidth(),canv.getHeight());

        int[][] array = getRandomArray();

        for (int x =  0; x < height; x+=PIXEL_WIDTH) {
            for (int y =  0; y < width; y+=PIXEL_WIDTH) {
                if( array[x][y] == 1){
                    gc.fillRect(x,y, PIXEL_WIDTH, PIXEL_WIDTH);
                }
                else
                    gc.rect(x,y, PIXEL_WIDTH, PIXEL_WIDTH);
            }
        }
        gc.stroke();
    }

    //create a random array which indicates which "cells" should be filled
    private int[][] getRandomArray(){
        int[][] array  = new int[height][ width];
        int filled = 0;
        while(filled <= percentage ){
            Random rand = new Random();
            int i = rand.nextInt(height);
            int j = rand.nextInt(width);
            if(array[i][j] == 0)
            {
                filled++;
                array[i][j] = 1;
            }
        }
        return  array;
    }
}