package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.Entity.Order;

import java.sql.*;

public interface OrderDAO extends CrudDAO<Order> {

    public String lastOrderId() throws SQLException, ClassNotFoundException;
    public boolean checkOrderIdExists(String orderId) throws SQLException, ClassNotFoundException;
    public boolean saveOrder(Order dto) throws SQLException, ClassNotFoundException;
    public String generateNewID() throws SQLException, ClassNotFoundException;
    public boolean exist(String id) throws SQLException, ClassNotFoundException;
}
