package dao;

import Util.CrudUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderDAOImpl implements  OrderDAO{


    public  boolean saveOrder(String orderId, Date orderDate, String customerId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Orders (id, `date`, customerID) VALUES (?,?,?)",orderId,orderDate,customerId);
    }

    public  boolean saveOrderDetails(String orderID, String itemCode, int qty, double unitPrice) throws SQLException, ClassNotFoundException {
        return  CrudUtil.execute("INSERT INTO OrderDetail (orderId, itemCode, qty, unitPrice) VALUES (?,?,?,?)",orderID,itemCode,qty,unitPrice);
    }

    public  String getLastOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT id FROM Orders ORDER BY id DESC LIMIT 1;");

        return rst.next() ? String.format("O%01d", (Integer.parseInt(rst.getString("id").replace("O", "")) + 1)) : "O01";
    }
}
