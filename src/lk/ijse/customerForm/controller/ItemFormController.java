package lk.ijse.customerForm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ItemFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField txtDesc;

    @FXML
    private TextField txtItem;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    @FXML
    void initialize() {
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'itemForm.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'itemForm.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'itemForm.fxml'.";
        assert txtDesc != null : "fx:id=\"txtDesc\" was not injected: check your FXML file 'itemForm.fxml'.";
        assert txtItem != null : "fx:id=\"txtItem\" was not injected: check your FXML file 'itemForm.fxml'.";
        assert txtPrice != null : "fx:id=\"txtPrice\" was not injected: check your FXML file 'itemForm.fxml'.";
        assert txtQty != null : "fx:id=\"txtQty\" was not injected: check your FXML file 'itemForm.fxml'.";

    }


    public void btnSave(ActionEvent event) {
    }

    public void btnUpdate(ActionEvent event) {
    }

    public void btnDelete(ActionEvent event) {
    }
}

