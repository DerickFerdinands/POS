package dao;

public interface CustomerDAO<T,ID> extends CrudDao<T,ID>{

    String getAddress();
}
