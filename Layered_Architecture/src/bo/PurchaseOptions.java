package bo;

import com.jfoenix.controls.JFXComboBox;
import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface PurchaseOptions {
    boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

    boolean existItem(String code) throws SQLException, ClassNotFoundException;

    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    String generateNewOrderId() throws SQLException, ClassNotFoundException;

    void loadAllCustomerIds(JFXComboBox cmbCustomerId) throws SQLException, ClassNotFoundException;

    void loadAllItemCodes(JFXComboBox cmbItemCode) throws SQLException, ClassNotFoundException;

    CustomerDTO getCustomer(String id) throws SQLException, ClassNotFoundException;

    ItemDTO getItem(String id) throws SQLException, ClassNotFoundException;
}
