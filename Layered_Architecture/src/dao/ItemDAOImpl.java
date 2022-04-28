package dao;

import Util.CrudUtil;
import model.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl {

    public static ArrayList<ItemDTO> getALlItems() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Item");
        ArrayList<ItemDTO> ItemList = new ArrayList<>();
        while(result.next()){
            ItemList.add(new ItemDTO(result.getString(1),result.getString(2),result.getBigDecimal(3),result.getInt(4)));
        }
        return ItemList;
    }
}
