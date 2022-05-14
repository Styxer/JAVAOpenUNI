package com.example.q2.Models;

import com.example.q2.Constants;
import com.example.q2.FileWorker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Dictionary {

    private SortedMap<String, String> dictionary;

    public Dictionary() {
        this.dictionary = new TreeMap<>();
        loadDictionary();
    }

    public SortedMap<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(SortedMap<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public void loadDictionary(){
        try {
            BufferedReader reader = FileWorker.LoadFromFile();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitter = line.split(":");
                String word = splitter[0].replace("\"", "").trim();
                String[] meaning = splitter[1].replace("\"", "").trim().split("\\d.");
                dictionary.put(word, meaning[0]);


            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

        }
    }

    public  String searchMeaning(String word){
        return dictionary.getOrDefault(word, "");
    }

    public  void deleteMeaning(String word){
        dictionary.remove(word);
    }

    public void updateMeaning(String word, String meaning){
        dictionary.replace(word, meaning);
    }

    public void addMeaning(String word, String meaning){
        dictionary.put(word, meaning);
    }
}
