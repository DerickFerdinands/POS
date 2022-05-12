package bo;

import dao.Custom.ItemDAO;
import dao.Custom.Impl.*;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemOptions {
    ItemDAO<ItemDTO, String> itemCrudOperations = new ItemDAOImpl();

    @Override
    public ArrayList<ItemDTO> getALlItems() throws SQLException, ClassNotFoundException {
        return itemCrudOperations.getAll();
    }

    Override

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemCrudOperations.delete(code);
    }

    Override

    public boolean saveItem(ItemDTO i) throws SQLException, ClassNotFoundException {
        return itemCrudOperations.save(i);
    }

    Override

    public boolean updateItem(ItemDTO i) throws SQLException, ClassNotFoundException {
        return itemCrudOperations.update(i);
    }

    Override

    public boolean itemExists(String i) throws SQLException, ClassNotFoundException {
        return itemCrudOperations.exists(i);
    }

    Override

    public String generateNewItemCode() throws SQLException, ClassNotFoundException {
        return itemCrudOperations.generateNewId();
    }
}
