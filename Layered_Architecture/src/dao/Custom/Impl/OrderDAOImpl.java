package dao.Custom.Impl;

import dao.Custom.OrderDAO;
import Util.CrudUtil;
import entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean save(Orders o) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Orders (id, `date`, customerID) VALUES (?,?,?)", o.getOid(), o.getDate(), o.getCustomerID());
    }

    @Override
    public ArrayList<Orders> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Orders o) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exists(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getLastID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT id FROM Orders ORDER BY id DESC LIMIT 1;");
        return rst.next() ? String.format("O%01d", (Integer.parseInt(rst.getString("id").replace("O", "")) + 1)) : "O01";
    }

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Orders get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }


//    public  boolean saveOrderDetails(String orderID, String itemCode, int qty, double unitPrice) throws SQLException, ClassNotFoundException {
//
//    }

}
