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

public class CustomerDAOImpl  implements  CustomerDAO{

    public  ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer");
        ArrayList<CustomerDTO> cusList = new ArrayList<>();
        while (rst.next()) {
            cusList.add(new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return cusList;
    }

    public  boolean saveCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", id, name, address);
    }

    public  boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Customer WHERE id=?", id);

    }

    public  boolean updateCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?", name, address, id);
    }

    public  boolean CustomerExists(String id) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT id FROM Customer WHERE id=?", id);
        return result.next();
    }

    public  String generateNewId() {
        try {

            ResultSet rst = CrudUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");
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

    public  String getLastCustomerID() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = CrudUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");
        if (rst.next()) {
            return rst.getString(1);
        } else {
            return null;
        }
    }

    public  ArrayList<String> getAllCustomerIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT id FROM Customer");
        ArrayList<String> CustomerIds = new ArrayList<>();
        while (result.next()) {
            CustomerIds.add(result.getString(1));
        }
        return CustomerIds;
    }

    public  CustomerDTO getCustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Customer WHERE id =?", id);

        return result.next() ? new CustomerDTO(result.getString(1), result.getString(2), result.getString(3)) : null;
    }
}
