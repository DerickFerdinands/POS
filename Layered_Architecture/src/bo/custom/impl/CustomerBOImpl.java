package bo.custom.impl;

import bo.custom.CustomerOptions;
import dao.Custom.CustomerDAO;
import dao.Custom.Impl.*;
import dao.DAOFactory;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerOptions {
    CustomerDAO<CustomerDTO, String> customerCRUDOperations = (CustomerDAOImpl) DAOFactory.getDAOFactoryInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerCRUDOperations.getAll();
    }

    @Override
    public boolean saveCustomer(CustomerDTO c) throws SQLException, ClassNotFoundException {
        return customerCRUDOperations.save(c);
    }

    @Override
    public boolean updateCustomer(CustomerDTO c) throws SQLException, ClassNotFoundException {
        return customerCRUDOperations.update(c);
    }

    @Override
    public boolean CustomerExists(String c) throws SQLException, ClassNotFoundException {
        return customerCRUDOperations.exists(c);
    }

    @Override
    public boolean deleteCustomer(String c) throws SQLException, ClassNotFoundException {
        return customerCRUDOperations.delete(c);
    }

    @Override
    public String GenerateNewCustomerID() throws SQLException, ClassNotFoundException {
        return customerCRUDOperations.generateNewId();
    }

    @Override
    public String getLastCustomerID() throws SQLException, ClassNotFoundException {
        return customerCRUDOperations.getLastID();
    }
}
