/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Money;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author yingy
 */
public interface MoneyDao {

    void addMoney(BigDecimal money) throws PersistenceException;

    BigDecimal returnMoney(BigDecimal money) throws PersistenceException;

    List<BigDecimal> listMoney() throws PersistenceException;

    BigDecimal calculateTotalMoney() throws PersistenceException;

    
}
