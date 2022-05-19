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

    private DAOFactory() {
    }

    public static DAOFactory getDAOFactoryInstance() {
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDERDETAILS:
                return new OrderDetailDAOImpl();
            case QUERYDAO:
                return new QueryDAOimpl();
            case ITEM:
                return new ItemDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER, QUERYDAO, ORDERDETAILS
    }
}
