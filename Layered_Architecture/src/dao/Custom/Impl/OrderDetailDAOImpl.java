package dao.Custom.Impl;

import dao.Custom.OrderDetailDAO;
import Util.CrudUtil;
import entity.OrderDetails;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean save(OrderDetails o) throws SQLException, ClassNotFoundException {
        return  CrudUtil.execute("INSERT INTO OrderDetail (orderId, itemCode, qty, unitPrice) VALUES (?,?,?,?)",o.getOid(),o.getItemCode(),o.getQty(),o.getUnitPrice());
    }

    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(OrderDetails o) throws SQLException, ClassNotFoundException {
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
        return null;
    }

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderDetails get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
