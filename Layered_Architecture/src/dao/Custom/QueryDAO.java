package dao.Custom;

import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO {
    public ArrayList<CustomDTO> searchOrderByOrderID(String id) throws SQLException, ClassNotFoundException;
}
