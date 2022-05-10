package dao.Custom;

import dao.CrudDao;

public interface CustomerDAO<T,ID> extends CrudDao<T,ID> {

    String getAddress();
}
