package com.example.lab2pc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class HelloController implements Initializable {
    public TableView <user> userTable;

    public TableColumn <user, Integer> appointmentid;

    public TableColumn <user,String> patientname;

    public TableColumn <user,String> appointmentdate;

    public TableColumn <user,String> doctor;

    public TextField uappointmentid;
    public TextField upatientname;
    public TextField uappointmentdate;
    public TextField udoctor;
    @FXML
    private Label welcomeText;

    ObservableList<user> list = FXCollections.observableArrayList();
    @FXML
    protected void onHelloButtonClick() {
        fetchdata();
    }
    private void fetchdata() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM user";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int appointmentid = resultSet.getInt("appointmentid");
                String patientname = resultSet.getString("patientname");
                String appointmentdate = resultSet.getString("appointmentdate");
                String doctor = resultSet.getString("doctor");
                userTable.getItems().add(new user(appointmentid,patientname, appointmentdate, doctor));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        appointmentid.setCellValueFactory(new PropertyValueFactory<user,Integer>("appointmentid"));
        patientname.setCellValueFactory(new PropertyValueFactory<user,String>("patientname"));
        appointmentdate.setCellValueFactory(new PropertyValueFactory<user,String>("appointmentdate"));
        doctor.setCellValueFactory(new PropertyValueFactory<user,String>("doctor"));
        userTable.setItems(list);
    }
    public void InsertData(ActionEvent actionEvent) {

        String patientname = upatientname.getText();
        String appointmentdate = uappointmentdate.getText();
        String doctor = udoctor.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `user`( `patientname`, `appointmentdate`, `memberpassword`) VALUES ('"+patientname+"','"+appointmentdate+"','"+doctor+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void UpdateData(ActionEvent actionEvent) {
        String appointmentid = uappointmentid.getText();
        String patientname = upatientname.getText();
        String appointmentdate = uappointmentdate.getText();
        String doctor = udoctor.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `user` SET `patientname`='"+patientname+"',`appointmentdate`='"+appointmentdate+"',`doctor`='"+doctor+"' WHERE appointmentid='"+appointmentid+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void DeleteData(ActionEvent actionEvent) {

        String appointmentid = uappointmentid.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `user` WHERE appointmentid='"+appointmentid+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LoadData(ActionEvent actionEvent) {

        String appointmentid = uappointmentid.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM user WHERE appointmentid='"+appointmentid+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String patientname = resultSet.getString("patientname");
                String appointmentdate = resultSet.getString("appointmentdate");
                String doctor = resultSet.getString("doctor");

                upatientname.setText(patientname);
                uappointmentdate.setText(appointmentdate);
                udoctor.setText(doctor);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
