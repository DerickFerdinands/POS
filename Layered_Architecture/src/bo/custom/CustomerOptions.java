package bo.custom;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerOptions extends SuperBO {
    ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

    boolean saveCustomer(CustomerDTO c) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerDTO c) throws SQLException, ClassNotFoundException;

    boolean CustomerExists(String c) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String c) throws SQLException, ClassNotFoundException;

    String GenerateNewCustomerID() throws SQLException, ClassNotFoundException;

    String getLastCustomerID() throws SQLException, ClassNotFoundException;
}
