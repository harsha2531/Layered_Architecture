package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {

    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    public void saveItem(ItemDTO item) throws SQLException, ClassNotFoundException;
    public int update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public void deleteItem(String code) throws SQLException, ClassNotFoundException;
    public boolean existItem(String code) throws SQLException, ClassNotFoundException;
    public String lastId() throws SQLException, ClassNotFoundException;
    public ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadItemIds() throws SQLException, ClassNotFoundException;
    }
