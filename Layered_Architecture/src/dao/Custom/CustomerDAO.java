package dao.Custom;

import dao.CrudDao;
import entity.Customer;

public interface CustomerDAO extends CrudDao<Customer,String> {

    String getAddress();
}
