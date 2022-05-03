package dao;

import Util.CrudUtil;
import db.DBConnection;
import javafx.scene.control.Alert;
import model.CustomerDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {


    ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

    boolean saveCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException;

    boolean CustomerExists(String id) throws SQLException, ClassNotFoundException;

    String generateNewId();


    String getLastCustomerID() throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllCustomerIds() throws SQLException, ClassNotFoundException;

    CustomerDTO getCustomer(String id) throws SQLException, ClassNotFoundException;
}
