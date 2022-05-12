package dao;

import dao.Custom.CustomerDAO;
import dao.Custom.Impl.*;
import dao.Custom.ItemDAO;
import dao.Custom.OrderDAO;
import dao.Custom.OrderDetailDAO;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private final ItemDAO<ItemDTO, String> itemCrudOperations;
    private final CustomerDAO<CustomerDTO, String> customerCRUDOperations;
    private final OrderDAO<OrderDTO, String> OrderCRUDOperations;
    private final OrderDetailDAO<OrderDetailDTO, String> OrderDetailCRUDOperations;
    private final QueryDAOimpl queryDAO;

    private DAOFactory() {
        daoFactory = new DAOFactory();
        itemCrudOperations = new ItemDAOImpl();
        customerCRUDOperations = new CustomerDAOImpl();
        OrderCRUDOperations = new OrderDAOImpl();
        OrderDetailCRUDOperations = new OrderDetailDAOImpl();
        queryDAO = new QueryDAOimpl();
    }

    public static DAOFactory getDAOFactoryInstance() {
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return  customerCRUDOperations;
            case ITEM:
                return  itemCrudOperations;
            case ORDER:
                return  OrderCRUDOperations;
            case ORDERDETAILS:
                return  OrderDetailCRUDOperations;
            case QUERYDAO:
                return  queryDAO;
            default:return null;
        }
    }

    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER, QUERYDAO, ORDERDETAILS
    }
}
