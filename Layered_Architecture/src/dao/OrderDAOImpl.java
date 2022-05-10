package dao;

import Util.CrudUtil;
import model.OrderDTO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO<OrderDTO, String> {
    @Override
    public boolean save(OrderDTO o) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Orders (id, `date`, customerID) VALUES (?,?,?)", o.getOrderId(), o.getOrderDate(), o.getCustomerId());
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(OrderDTO o) throws SQLException, ClassNotFoundException {
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
    public OrderDTO get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }


//    public  boolean saveOrderDetails(String orderID, String itemCode, int qty, double unitPrice) throws SQLException, ClassNotFoundException {
//
//    }

}
