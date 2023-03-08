package lk.ijse.customerForm.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.awt.*;
import java.sql.*;
import java.util.Properties;

public class CustomerFormController {
    private static final String URL = "jdbc:mysql://localhost:3306/foodcity ? useSSL=false";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user","root");
        props.setProperty("password","1234");
    }


    public Label lbl;
    @FXML
    private JFXButton btnB;
    @FXML
    private TextField address;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField salary;


    @FXML
     void btnSave(ActionEvent event) throws SQLException {
        System.out.println("ob");
      String Id = id.getText();
      String Name = name.getText();
      String Address = address.getText();
      double Salary = Double.parseDouble(salary.getText());

        try(Connection connection = DriverManager.getConnection(URL, props)){
            String sql = "INSERT INTO customer(id,name,address,salary)"+"VALUES(?,?,?,?)";

            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,Id);
            pstm.setString(2,Name);
            pstm.setString(3,Address);
            pstm.setDouble(4,Salary);

            int  affectedRows = pstm.executeUpdate();
            if(affectedRows > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();
            }


        }


    }


    @FXML
     void btnOndelete(ActionEvent event) throws SQLException {
        System.out.println("e");
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "DELETE FROM customer WHERE id = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id.getText());

            int  affectedRows = pstm.executeUpdate();

            if(affectedRows > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "DELETE Successfully!").show();
            }
            id.setText(" ");
            name.setText(" ");
            address.setText(" ");
            salary.setText(" ");


        }

    }

    String onActionId;
    public void btnOnSave(ActionEvent event) throws SQLException {
        onActionId=id.getText();


        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "SELECT * FROM customer WHERE id = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id.getText());

            ResultSet resultSet = pstm.executeQuery();

            if(resultSet.next()) {
                //String cus_id = resultSet.getString(1);
                String cus_name = resultSet.getString(2);
                String cus_address = resultSet.getString(3);
                double cus_salary = resultSet.getDouble(4);

                //id.setText(cus_id);
               name.setText(cus_name);
               address.setText(cus_address);
               salary.setText(String.valueOf(cus_salary));


            }
        }
    }
    @FXML

    void btnUpdate(ActionEvent event) throws SQLException {

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "UPDATE customer SET id = ?, name = ?, address = ?, salary =? WHERE id = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id.getText());
            pstm.setString(2, name.getText());
            pstm.setString(3, address.getText());
            pstm.setString(4, salary.getText());
            pstm.setString(5, onActionId);

            int  affectedRows = pstm.executeUpdate();

            if(affectedRows > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "Update Successfully!").show();
            }
            id.setText(" ");
            name.setText(" ");
            address.setText(" ");
            salary.setText(" ");


        }



    }
}
