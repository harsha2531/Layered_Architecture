package com.example.layeredarchitecture.dao.custom.Impl;

import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.OrderDetailsDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.Entity.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    ItemDAO itemDAO = new ItemDAOImpl();
    public boolean saveOrderDetail(OrderDetail orderDetail) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");

        stm.setString(1, orderDetail.getOid());
        stm.setString(2, orderDetail.getItemCode());
        stm.setBigDecimal(3, orderDetail.getUnitPrice());
        stm.setInt(4, orderDetail.getQty());
        return stm.executeUpdate()==1;
    }

    @Override
    public ArrayList<OrderDetail> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(OrderDetail dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDetail dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existId(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String lastId() throws SQLException, ClassNotFoundException {
        return "";
    }

    @Override
    public OrderDetail find(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String GenerateNextId() throws SQLException, ClassNotFoundException {
        return "";
    }
}

/*public boolean addOrderDetails(String orderId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {


    for (OrderDetailDTO detail : orderDetails) {

        String itemCode = detail.getItemCode();
        BigDecimal unitPrice = detail.getUnitPrice();
        int qty = detail.getQty();


        boolean added = saveOrderDetail(orderId, new OrderDetailDTO(itemCode, qty, unitPrice));
        System.out.println("add-" + added);


        //Search & Update Item



        ItemDTO item = itemDAO.searchItem(detail.getItemCode());
        item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());


        int x =itemDAO.update(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));


        if (!added && !(x > 0)) {

            return false;
        }


    }
    return  true;
}*/
