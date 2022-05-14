package com.example.q2;

import com.example.q2.Models.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button addBtn;

    @FXML
    private ListView<String> listView;

    @FXML
    private Button removeBtn;

    @FXML
    private Button searchBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private TextField searchTxt;

    @FXML
    private TextField newMeaningTxt;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField selectedMeaningTxt;

    @FXML
    private Button updateBtn;

    @FXML
    private Button loadFromFileBtn;

    @FXML
    private Button saveToFileBtn;

    private Dictionary dictionary;

    private Boolean isUpdate;

    //add word-meaning button event
    @FXML
    void OnAddBtn(ActionEvent event) {

        isUpdate = false;
        setNewMeaningTxtDisabled(false);
        setTxtAreaDisabled(false);
        setUpdateBtnDisabled(true);
        setRemoveBtnDisabled(true);
        setSaveBtnDisabled(false);
        setAddBtnDisabled(true);

    }

    //remove word-meaning button event
    @FXML
    void OnRemoveBtn(ActionEvent event) {
        String selectedItem =  listView.getSelectionModel().getSelectedItem();
        dictionary.deleteMeaning(selectedItem);
        addItemsToListView();
    }

    //search word button event
    @FXML
    void onSearchBtn(ActionEvent event) {
        addItemsToListView();
    }

    //update meaning button event
    @FXML
    void onUpdateBtn(ActionEvent event) {

        isUpdate = true;
        setAddBtnDisabled(true);
        setRemoveBtnDisabled(true);
        setSaveBtnDisabled(false);
        setTxtAreaDisabled(false);
    }

    //save dictionary to file button event
    @FXML
    void onSaveBtn(ActionEvent event) {

        String selectedItem;
        String meaning = txtArea.getText();

        if(isUpdate){//update
            selectedItem =  listView.getSelectionModel().getSelectedItem();
            dictionary.updateMeaning(selectedItem, meaning);
        }else{ //save
            selectedItem = newMeaningTxt.getText() ;
            dictionary.addMeaning(selectedItem, meaning);
            addItemsToListView();
        }

        setTxtAreaDisabled(true);
        setNewMeaningTxtDisabled(true);
        setSaveBtnDisabled(true);
        setUpdateBtnDisabled(false);
        setRemoveBtnDisabled(false);
        setAddBtnDisabled(false);

    }

    //show search result(s) to the list-view according the word that user typed
    @FXML
    void onMousePressedListView(MouseEvent event) {
        String selectedItem =  listView.getSelectionModel().getSelectedItem();
        String meaning = dictionary.searchMeaning(selectedItem);
        txtArea.setText(meaning);
        searchTxt.setText(selectedItem);
    }


    //load file from disk button event
    @FXML
    void onLoadFromFileBtn(ActionEvent event) {
        dictionary.loadDictionary();
    }

    //save file to disk button event
    @FXML
    void onSaveToFileBtn(ActionEvent event) {
        FileWorker.writeToFile(dictionary.getDictionary());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dictionary = new Dictionary();
    }

    //add item to the list-view according the search word
    private void addItemsToListView(){
        listView.getItems().clear();
        for (var entry : dictionary.getDictionary().entrySet()){
            if(entry.getKey().contains(searchTxt.getText())){
                listView.getItems().add(entry.getKey());
            }
        }
        if(!listView.getItems().isEmpty()){
            setUpdateBtnDisabled(false);
            setRemoveBtnDisabled(false);
        }else{
            setUpdateBtnDisabled(true);
            setRemoveBtnDisabled(true);
        }
    }


    //set add button disable state
    private void setAddBtnDisabled(Boolean state){
        addBtn.setDisable(state);
    }

    //set update button disable state
    private void setUpdateBtnDisabled(boolean state){
        updateBtn.setDisable(state);
    }

    //set remove button disable state
    private void setRemoveBtnDisabled(Boolean state){
        removeBtn.setDisable(state);
    }

    //set save button disable state
    private void setSaveBtnDisabled(boolean state){
        saveBtn.setDisable(state);
    }



    //set text area(  disable and editable state and text
    private void setTxtAreaDisabled(boolean state){
        txtArea.setDisable(state);
        txtArea.setEditable(!state);

        if(!txtArea.isDisable())
            txtArea.setText("");
    }


    //set new word  disable and editable state and text
    private void setNewMeaningTxtDisabled(Boolean state){
        newMeaningTxt.setDisable(state);
        newMeaningTxt.setEditable(!state);

        if(!newMeaningTxt.isEditable())
            txtArea.setText("");
    }
}