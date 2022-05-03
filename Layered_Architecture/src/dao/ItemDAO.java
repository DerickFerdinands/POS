package dao;

import Util.CrudUtil;
import javafx.scene.control.Alert;
import model.ItemDTO;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {

    public  ArrayList<ItemDTO> getALlItems() throws SQLException, ClassNotFoundException ;
    public  boolean deleteItem(String id) throws SQLException, ClassNotFoundException ;
    public  boolean saveItem(ItemDTO item) throws SQLException, ClassNotFoundException ;

    public  boolean updateItem(String desc, BigDecimal unitPrice, int qtyOnHand, String code) throws SQLException, ClassNotFoundException;

    public  boolean itemExists(String code) throws SQLException, ClassNotFoundException;

    public  String generateNewId() ;
    public  ItemDTO getItem(String code) throws SQLException, ClassNotFoundException ;
    public  ArrayList<String> getAllItemCodes() throws SQLException, ClassNotFoundException ;

}
