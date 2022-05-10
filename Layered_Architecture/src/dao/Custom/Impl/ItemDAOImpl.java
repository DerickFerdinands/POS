package dao.Custom.Impl;

import dao.Custom.ItemDAO;
import Util.CrudUtil;
import model.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO<ItemDTO, String> {
    @Override
    public boolean save(ItemDTO o) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", o.getCode(), o.getDescription(), o.getUnitPrice(), o.getQtyOnHand());
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Item");
        ArrayList<ItemDTO> ItemList = new ArrayList<>();
        while (result.next()) {
            ItemList.add(new ItemDTO(result.getString(1), result.getString(2), result.getBigDecimal(3), result.getInt(4)));
        }
        return ItemList;
    }

    @Override
    public boolean update(ItemDTO o) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", o.getDescription(), o.getUnitPrice(), o.getQtyOnHand(), o.getCode());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Item WHERE code=?", s);
    }

    @Override
    public boolean exists(String s) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT code FROM Item WHERE code=?", s);
        return result.next();
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("P", "")) + 1;
            return String.format("P%03d", newItemId);
        } else {
            return "P001";
        }
    }

    @Override
    public String getLastID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT code FROM Item");
        ArrayList<String> ItemCOdes = new ArrayList<>();

        while (result.next()) {
            ItemCOdes.add(result.getString(1));
        }
        return ItemCOdes;
    }

    @Override
    public ItemDTO get(String s) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Item WHERE code=?", s);
        if (result.next()) {
            return new ItemDTO(result.getString(1), result.getString(2), result.getBigDecimal(3), result.getInt(4));
        }
        return null;
    }

}
