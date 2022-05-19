package dao.Custom;

import dao.CrudDao;
import entity.Customer;
import model.CustomerDTO;

public interface CustomerDAO extends CrudDao<Customer,String> {

    String getAddress();
}
