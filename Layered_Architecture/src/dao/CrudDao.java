package dao;

import Util.CrudUtil;
import db.DBConnection;
import model.CustomerDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDao<T,ID> {

    boolean save(T o) throws SQLException, ClassNotFoundException;

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean update(T o) throws SQLException, ClassNotFoundException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException;

    boolean exists(ID id) throws SQLException, ClassNotFoundException;

    ID generateNewId() throws SQLException, ClassNotFoundException;

    ID getLastID() throws SQLException, ClassNotFoundException;

    ArrayList<ID> getAllIds() throws SQLException, ClassNotFoundException;

    T get(ID id) throws SQLException, ClassNotFoundException;
}
