package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    public void saveCustomer(CustomerDTO customer ) throws SQLException, ClassNotFoundException;
    public void updateCustomer(CustomerDTO customer ) throws SQLException, ClassNotFoundException;
    public void deleteCustomer(String id ) throws SQLException, ClassNotFoundException;
    public boolean  existCustomerId(String id) throws SQLException, ClassNotFoundException;
    public String lastId() throws SQLException, ClassNotFoundException;
    public CustomerDTO findCustomer(String newValue) throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadCustomerIds() throws SQLException, ClassNotFoundException;

    }
