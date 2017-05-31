/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yingy
 */
public class ItemDaoStubImpl implements ItemDao{
    Item onlyFruit;
    List<Item> fruitList = new ArrayList<>();
    
    public ItemDaoStubImpl(){
        onlyFruit = new Item("20");
        onlyFruit.setItemName("Durian");
        onlyFruit.setItemPrice(new BigDecimal("100"));
        onlyFruit.setQuantity(5);
    }
    
    @Override
    public Item addItem(String itemId, Item item) throws PersistenceException {
        if (itemId.equals(onlyFruit.getItemId())) {
            return onlyFruit;
        } else {
            return null;
        }
    }

    @Override
    public List<Item> getAllItemsAvailable() throws PersistenceException {
        return fruitList;
    }

    @Override
    public List<Item> checkInventory(List<Item> itemList) throws PersistenceException {
        return fruitList;
    }

    @Override
    public Item dispenseItem(Item item) throws PersistenceException {
        if (item.equals(onlyFruit.getItemId())) {
            return onlyFruit;
        } else {
            return null;
        }
    }

    @Override
    public Item decrementInventory(Item item) throws PersistenceException {
        if (item.equals(onlyFruit.getItemId())) {
            return onlyFruit;
        } else {
            return null;
        }
    }
    
}
