package com.example.q2.Models;

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

    private void loadDictionary(){
        String filePath = "src\\main\\resources\\com\\example\\q2\\Dictionary\\dictionary.txt";
        Path path = Paths.get(filePath);
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitter = line.split(":");
                String word = splitter[0].replace("\"", "").trim();
              //  String t = "1. The act of devoting; consecration. 2. The state of being devoted; addiction; eager inclination; strong attachment love or affection; zeal; especially, feelings toward God appropriately expressed by acts of worship; devoutness. Genius animated by a fervent spirit of devotion. Macaulay. 3. Act of devotedness or devoutness; manifestation of strong attachment; act of worship; prayer. \\\"The love of public devotion.\\\" Hooker. 4. Disposal; power of disposal. [Obs.] They are entirely at our devotion, and may be turned backward and forward, as we please. Godwin. 5. A thing consecrated; an object of devotion. [R.] Churches and altars, priests and all devotions, Tumbled together into rude chaos. Beau. & Fl. Days of devotion. See under Day. Syn. -- Consecration; devoutness; religiousness; piety; attachment; devotedness; ardor; earnestness.\",";
              //  String[] tt = t.split("\\d.");
                String[] meaning = splitter[1].replace("\"", "").trim().split("\\d.");
                dictionary.put(word, meaning[0]);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  String searchMeaning(String word){
        String meaning =  dictionary.getOrDefault(word, "");
        return  meaning;
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
