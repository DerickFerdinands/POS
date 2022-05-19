package dao.Custom;

import dao.CrudDao;
import model.CustomerDTO;

public interface CustomerDAO extends CrudDao<CustomerDTO,String> {

    String getAddress();
}
