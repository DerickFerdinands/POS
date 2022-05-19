package bo.custom.impl;

import bo.custom.ItemOptions;
import dao.Custom.ItemDAO;
import dao.Custom.Impl.*;
import dao.DAOFactory;
import entity.Item;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemOptions {
    ItemDAO itemCrudOperations = (ItemDAOImpl)DAOFactory.getDAOFactoryInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<ItemDTO> getALlItems() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> itemList = new ArrayList<>();
        for(Item i : itemCrudOperations.getAll()){
            itemList.add(new ItemDTO(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand()));
        }
        return itemList;
    }

    @Override

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemCrudOperations.delete(code);
    }

    @Override

    public boolean saveItem(ItemDTO i) throws SQLException, ClassNotFoundException {
        return itemCrudOperations.save(new Item(i.getCode(),i.getDescription(),i.getQtyOnHand(),i.getUnitPrice()));
    }

    @Override

    public boolean updateItem(ItemDTO i) throws SQLException, ClassNotFoundException {
        return itemCrudOperations.update(new Item(i.getCode(),i.getDescription(),i.getQtyOnHand(),i.getUnitPrice()));
    }

    @Override

    public boolean itemExists(String i) throws SQLException, ClassNotFoundException {
        return itemCrudOperations.exists(i);
    }

    @Override

    public String generateNewItemCode() throws SQLException, ClassNotFoundException {
        return itemCrudOperations.generateNewId();
    }
}
