package dao.Custom.Impl;

import dao.Custom.CustomerDAO;
import Util.CrudUtil;
import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean save(CustomerDTO o) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", o.getId(), o.getName(), o.getAddress());
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer");
        ArrayList<CustomerDTO> cusList = new ArrayList<>();
        while (rst.next()) {
            cusList.add(new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return cusList;
    }

    @Override
    public boolean update(CustomerDTO o) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?", o.getName(), o.getAddress(), o.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Customer WHERE id=?", id);
    }

    @Override
    public boolean exists(String id) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT id FROM Customer WHERE id=?", id);
        return result.next();
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C", "")) + 1;
            return String.format("C%03d", newCustomerId);
        } else {
            return "C001";
        }
    }

    @Override
    public String getLastID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");
        if (rst.next()) {
            return rst.getString(1);
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT id FROM Customer");
        ArrayList<String> CustomerIds = new ArrayList<>();
        while (result.next()) {
            CustomerIds.add(result.getString(1));
        }
        return CustomerIds;
    }

    @Override
    public CustomerDTO get(String id) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Customer WHERE id =?", id);
        return result.next() ? new CustomerDTO(result.getString(1), result.getString(2), result.getString(3)) : null;
    }

    @Override
    public String getAddress() {
        return null;
    }
}
