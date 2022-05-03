package dao;

import Util.CrudUtil;
import db.DBConnection;
import javafx.scene.control.Alert;
import model.ItemDTO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements  ItemDAO{


    public  ArrayList<ItemDTO> getALlItems() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Item");
        ArrayList<ItemDTO> ItemList = new ArrayList<>();
        while (result.next()) {
            ItemList.add(new ItemDTO(result.getString(1), result.getString(2), result.getBigDecimal(3), result.getInt(4)));
        }
        return ItemList;
    }

    public  boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Item WHERE code=?", id);
    }

    public  boolean saveItem(ItemDTO item) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
    }

    public  boolean updateItem(String desc, BigDecimal unitPrice, int qtyOnHand, String code) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", desc, unitPrice, qtyOnHand, code);
    }

    public  boolean itemExists(String code) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT code FROM Item WHERE code=?", code);
        return result.next();
    }

    public  String generateNewId() {
        try {
            ResultSet rst = CrudUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1");
            if (rst.next()) {
                String id = rst.getString("code");
                int newItemId = Integer.parseInt(id.replace("P", "")) + 1;
                return String.format("P%03d", newItemId);
            } else {
                return "P001";
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "P001";
    }

    public  ItemDTO getItem(String code) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Item WHERE code=?", code);

        if (result.next()) {
            return new ItemDTO(result.getString(1), result.getString(2), result.getBigDecimal(3), result.getInt(4));
        }
        return null;
    }

    public  ArrayList<String> getAllItemCodes() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT code FROM Item");
        ArrayList<String> ItemCOdes = new ArrayList<>();

        while (result.next()) {
            ItemCOdes.add(result.getString(1));
        }
        return ItemCOdes;
    }


}
