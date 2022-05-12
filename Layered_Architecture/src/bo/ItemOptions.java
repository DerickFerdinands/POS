package bo;

import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemOptions {
    ArrayList<ItemDTO> getALlItems() throws SQLException, ClassNotFoundException;

    boolean deleteItem(String code) throws SQLException, ClassNotFoundException;

    boolean saveItem(ItemDTO i) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO i) throws SQLException, ClassNotFoundException;

    boolean itemExists(String i) throws SQLException, ClassNotFoundException;

    String generateNewItemCode() throws SQLException, ClassNotFoundException;
}
