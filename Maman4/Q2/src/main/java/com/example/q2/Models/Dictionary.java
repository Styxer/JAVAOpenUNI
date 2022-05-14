package com.example.q2.Models;

import com.example.q2.FileWorker;

import java.io.*;
import java.util.SortedMap;
import java.util.TreeMap;

//Represents a dictionary class
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

    //Load dictionary from file
    public void loadDictionary(){
        try {
            BufferedReader reader = FileWorker.loadFromFile();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitter = line.split(":");
                //Remove unnecessary "\" chars
                String word = splitter[0].replace("\"", "").trim();
                String meaning = splitter[1].replace("\"", "").trim().replaceAll("\\d.","\n");//add new line for each meaning 
                dictionary.put(word, meaning);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

        }
    }

    //search for a meaning in the dictionary, returns nothing if not found
    public  String searchMeaning(String word){
        return dictionary.getOrDefault(word, "");
    }

    //delete meaning from the dictionary, do nothing if not found
    public  void deleteMeaning(String word){
        dictionary.remove(word);
    }

    //update meaning of a word in the dictionary, do nothing if not ofund
    public void updateMeaning(String word, String meaning){
        dictionary.replace(word, meaning);
    }

    //add a new word-meaning pair to the dictionary
    public void addMeaning(String word, String meaning){
        if(dictionary.containsKey(word)){
            dictionary.put(word, meaning);
        }

    }
}
