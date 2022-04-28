package dao;

import Util.CrudUtil;
import db.DBConnection;
import javafx.scene.control.Alert;
import model.CustomerDTO;
import view.tdm.CustomerTM;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerDAOImpl {

    public static ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer");
        ArrayList<CustomerDTO> cusList = new ArrayList<>();
        while (rst.next()) {
            cusList.add(new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return cusList;
    }

    public static boolean saveCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",id,name,address);
    }

    public static boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Customer WHERE id=?",id);

    }

    public static boolean updateCustomer(String id , String name, String address) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement();
        pstm.setString(1, name);
        pstm.setString(2, address);
        pstm.setString(3, id);
        return CrudUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?")
    }

    public static boolean CustomerExists(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
        pstm.setString(1, id);
        return pstm.executeQuery().next();
    }

    public static String generateNewId(){
        try {
            Connection connection = DBConnection.getDbConnection().getConnection();
            ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
            if (rst.next()) {
                String id = rst.getString("id");
                int newCustomerId = Integer.parseInt(id.replace("C", "")) + 1;
                return String.format("C%03d", newCustomerId);
            } else {
                return "C001";
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new id " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getLastCustomerID() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            return rst.getString(1);
        } else {
            return null;
        }
    }
}
