package dao.Custom.Impl;

import Util.CrudUtil;
import dao.Custom.QueryDAO;
import model.CustomDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class QueryDAOimpl implements QueryDAO{

    @Override
    public ArrayList<CustomDTO> searchOrderByOrderID(String id) throws SQLException, ClassNotFoundException{
        ResultSet rst = CrudUtil.execute("select Orders.oid,Orders.date,Orders.customerID,OrderDetails.itemCode,OrderDetails.qty,OrderDetails.unitPrice from Orders inner join OrderDetails on Orders.oid=OrderDetails.oid where Orders.oid=?;", id);
        ArrayList<CustomDTO> orderRecords = new ArrayList();
        while (rst.next()) {
            orderRecords.add(new CustomDTO(rst.getString(1), LocalDate.parse(rst.getString(2)), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getBigDecimal(6)));
        }
        return orderRecords;
    }
}
