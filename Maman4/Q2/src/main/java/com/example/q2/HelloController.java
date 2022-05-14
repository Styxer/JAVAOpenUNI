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

    @FXML
    void OnRemoveBtn(ActionEvent event) {
        String selectedItem =  listView.getSelectionModel().getSelectedItem();
        dictionary.deleteMeaning(selectedItem);
        addItemsToListView();
    }

    @FXML
    void onSearchBtn(ActionEvent event) {
        addItemsToListView();
    }

    @FXML
    void onUpdateBtn(ActionEvent event) {

        isUpdate = true;
        setAddBtnDisabled(true);
        setRemoveBtnDisabled(true);
        setSaveBtnDisabled(false);
        setTxtAreaDisabled(false);
    }

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

    @FXML
    void onMousePressedListView(MouseEvent event) {
        String selectedItem =  listView.getSelectionModel().getSelectedItem();
        String meaning = dictionary.searchMeaning(selectedItem);
        txtArea.setText(meaning);
        searchTxt.setText(selectedItem);
    }

    @FXML
    void onLoadFromFileBtn(ActionEvent event) {
        dictionary.loadDictionary();
    }

    @FXML
    void onSaveToFileBtn(ActionEvent event) {
        FileWorker.writeToFile(dictionary.getDictionary(), Constants.TEST_FILE_LOCATION1);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dictionary = new Dictionary();
    }

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


    private void setAddBtnDisabled(Boolean state){
        addBtn.setDisable(state);
    }

    private void setUpdateBtnDisabled(boolean state){
        updateBtn.setDisable(state);
    }

    private void setRemoveBtnDisabled(Boolean state){
        removeBtn.setDisable(state);
    }

    private void setSaveBtnDisabled(boolean state){
        saveBtn.setDisable(state);
    }

    private void setTxtAreaDisabled(boolean state){
        txtArea.setDisable(state);
        txtArea.setEditable(!state);

        if(!txtArea.isEditable())
            txtArea.setText("");
    }
    private void setNewMeaningTxtDisabled(Boolean state){
        newMeaningTxt.setDisable(state);
        newMeaningTxt.setEditable(!state);

        if(!newMeaningTxt.isEditable())
            txtArea.setText("");
    }
}