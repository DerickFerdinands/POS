package bo.custom.impl;

import bo.custom.PurchaseOptions;
import com.jfoenix.controls.JFXComboBox;
import dao.CrudDao;
import dao.Custom.*;
import dao.DAOFactory;
import db.DBConnection;
import entity.Customer;
import entity.Item;
import entity.OrderDetails;
import entity.Orders;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;
import dao.Custom.Impl.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PurchaseOrderBOImpl implements PurchaseOptions {


    private final ItemDAO itemCrudOperations = (ItemDAOImpl) DAOFactory.getDAOFactoryInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    private final CustomerDAO customerCRUDOperations = (CustomerDAOImpl) DAOFactory.getDAOFactoryInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private final OrderDAO OrderCRUDOperations = (OrderDAOImpl) DAOFactory.getDAOFactoryInstance().getDAO(DAOFactory.DAOTypes.ORDER);
    private final OrderDetailDAO OrderDetailCRUDOperations = (OrderDetailDAOImpl) DAOFactory.getDAOFactoryInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);
    private final QueryDAO joinQueryOps = (QueryDAOimpl) DAOFactory.getDAOFactoryInstance().getDAO(DAOFactory.DAOTypes.QUERYDAO);

    @Override
    public boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        connection.setAutoCommit(false);

        if (!OrderCRUDOperations.save(new Orders(orderId, orderDate, customerId))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }


        for (OrderDetailDTO detail : orderDetails) {


            if (!OrderDetailCRUDOperations.save(new OrderDetails(orderId, detail.getItemCode(), detail.getQty(), detail.getUnitPrice()))) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

//                //Search & Update Item
            Item item = itemCrudOperations.get(detail.getItemCode());
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

            if (!(itemCrudOperations.update(item))){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
        }

        connection.commit();
        connection.setAutoCommit(true);
        return true;

    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemCrudOperations.exists(code);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerCRUDOperations.exists(id);
    }

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return OrderCRUDOperations.getLastID();
    }

    @Override
    public void loadAllCustomerIds(JFXComboBox cmbCustomerId) throws SQLException, ClassNotFoundException {
        cmbCustomerId.getItems().addAll(customerCRUDOperations.getAllIds());
    }

    @Override
    public void loadAllItemCodes(JFXComboBox cmbItemCode) throws SQLException, ClassNotFoundException {
        cmbItemCode.getItems().addAll(itemCrudOperations.getAllIds());
    }

    @Override
    public CustomerDTO getCustomer(String id) throws SQLException, ClassNotFoundException {
        Customer customer = customerCRUDOperations.get(id);
        return new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());
    }

    @Override
    public ItemDTO getItem(String id) throws SQLException, ClassNotFoundException {
        Item item = itemCrudOperations.get(id);
        return new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
    }
}
