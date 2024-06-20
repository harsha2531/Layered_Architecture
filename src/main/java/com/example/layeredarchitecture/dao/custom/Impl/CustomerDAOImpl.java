package com.example.layeredarchitecture.dao.custom.Impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.Entity.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {


    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
*/
        ArrayList<Customer>  allCustomers = new ArrayList<>();
        ResultSet rst  = SQLUtil.execute("select * from customer");


        while (rst.next()) {
            Customer customer = new Customer
                    (rst.getString("id"),
                            rst.getString("name"),
                    rst.getString("address"));
            allCustomers.add(customer);
        }
        return allCustomers;
    }

    public boolean add(Customer customer ) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
        pstm.setString(1, customer.getId());
        pstm.setString(2, customer.getName());
        pstm.setString(3, customer.getAddress());*/
        return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",customer.getId(),customer.getName(),customer.getAddress());
        //pstm.executeUpdate();
    }
    public boolean update(Customer customer ) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
        pstm.setString(1, customer.getId());
        pstm.setString(2, customer.getName());
        pstm.setString(3, customer.getId());
        pstm.executeUpdate();*/
        return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",customer.getId(),customer.getName(),customer.getId());
    }
    public boolean delete(String id ) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setString(1, id);
        pstm.executeUpdate();
*/
        return SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }

    public boolean  existId(String id) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
        pstm.setString(1, id);
        return pstm.executeQuery().next();*/
        ResultSet rst =   SQLUtil.execute("SELECT COUNT(*) FROM Customer WHERE id=?",id);
        return rst.next();

    }
    public String lastId() throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");*/

        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");

        if (rst.next()){
            return rst.getString(1);
        }return null;

    }
    public Customer find(String newValue) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
        pstm.setString(1, newValue + "");
        ResultSet rst = pstm.executeQuery();
        rst.next();
        return  new CustomerDTO(newValue + "", rst.getString("name"), rst.getString("address"));
*/
        return SQLUtil.execute("SELECT * FROM Customer WHERE id=?",(newValue + ""));




    }

    @Override
    public String GenerateNextId() throws SQLException, ClassNotFoundException {
        return "";
    }

    public ArrayList<String> loadIds() throws SQLException, ClassNotFoundException {

        /*
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");*/
        ArrayList<String> arrayList = new ArrayList<>();
        ResultSet rst =  SQLUtil.execute("SELECT * FROM Customer");

        while (rst.next()){
            arrayList.add(rst.getString(1));


        }
        return arrayList;
    }



}
