package dao;

import Util.CrudUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderDAO {

    public  boolean saveOrder(String orderId, Date orderDate, String customerId) throws SQLException, ClassNotFoundException ;

    public  boolean saveOrderDetails(String orderID, String itemCode, int qty, double unitPrice) throws SQLException, ClassNotFoundException ;

    public  String getLastOrderId() throws SQLException, ClassNotFoundException ;
}
