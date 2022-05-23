package com.example.q2;

import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;

//Represents a class that handles with files
public class FileWorker {

    //write the content of the dictionary to a location that the user selected
    public static void writeToFile(SortedMap<String, String> dictionary){
        String a = String.valueOf(getFileLocation());
        try {
            FileWriter writer = new FileWriter(a);
            writer.write("");
            for (Map.Entry<String,String>  entry : dictionary.entrySet()){
                writer.write("\"" + entry.getKey() + "\"" + ":" + "\"" + entry.getValue() + "\"" + "\r\n" );
            }
            writer.close();

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    //load file from the disk
    public static BufferedReader loadFromFile() {
        BufferedReader reader;
        try {
            reader = Files.newBufferedReader(Objects.requireNonNull(getFileLocation()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return reader;
    }

    //get  the file location that user selected
    private static Path getFileLocation(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a file");
        fileChooser.setInitialDirectory(new File("."));
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile == null){ //if cancel pressed
            //handle it
            return  null;
        }else{
            Constants.FILE_PATH = Paths.get(selectedFile.getPath());
        }

        return Constants.FILE_PATH;

    }
}
