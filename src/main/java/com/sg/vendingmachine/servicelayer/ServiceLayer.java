/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.servicelayer;

import com.sg.vendingmachine.dao.PersistenceException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.Money;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author yingy
 */
public interface ServiceLayer {

    void addMoney(BigDecimal money) throws PersistenceException;

    BigDecimal returnMoney(BigDecimal money) throws PersistenceException;

    List<BigDecimal> listMoney() throws PersistenceException;

    BigDecimal calculateTotalMoney() throws PersistenceException;

    Item addItem(String itemId, Item item) throws PersistenceException;

    List<Item> getAllItemsAvailable() throws PersistenceException;

    Change coinChange(BigDecimal total);

    List<Item> checkInventory(List<Item> itemList) throws PersistenceException;

    Item dispenseItem(Item item) throws PersistenceException;

//    List<Item> minusQuantity(List<Item> itemList) throws PersistenceException;
    Item decrementInventory(Item item) throws PersistenceException;

    boolean areFundsEnough(Item item) throws
            InsufficientFundsException,
            PersistenceException;

    boolean isStocked(Item item) throws
            NoItemInventoryException;
}

