package com.example.q2;

import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.SortedMap;

public class FileWorker {
    public static void writeToFile(SortedMap<String, String> dictionary, String fileLocation){
        try {
            FileWriter writer = new FileWriter(fileLocation);
            writer.write("");
            for (var entry : dictionary.entrySet()){
                writer.write("\"" + entry.getKey() + "\"" + ":" + "\"" + entry.getValue() + "\"" + "\r\n" );
            }
            writer.close();

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static BufferedReader LoadFromFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a file");
        fileChooser.setInitialDirectory(new File("."));
        File selectedFile = fileChooser.showOpenDialog(null);
        Constants.FILE_PATH = Path.of(selectedFile.getPath());
        BufferedReader reader;
        try {
            reader = Files.newBufferedReader(Constants.FILE_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return reader;
    }
}
