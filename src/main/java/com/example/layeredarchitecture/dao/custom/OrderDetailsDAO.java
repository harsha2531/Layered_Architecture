package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.dao.custom.Impl.ItemDAOImpl;
import com.example.layeredarchitecture.Entity.OrderDetail;

import java.sql.SQLException;

public interface OrderDetailsDAO extends CrudDAO<OrderDetail> {
        ItemDAO itemDAO = new ItemDAOImpl();
        public boolean saveOrderDetail(OrderDetail orderDetail) throws SQLException, ClassNotFoundException;
}
