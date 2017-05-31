/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.servicelayer;

import com.sg.vendingmachine.dao.AuditDao;
import com.sg.vendingmachine.dao.PersistenceException;
import com.sg.vendingmachine.dao.ItemDao;
import com.sg.vendingmachine.dao.MoneyDao;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.Money;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author yingy
 */
public class ServiceLayerImpl implements ServiceLayer{
    
    private ItemDao itemDao;
    private MoneyDao moneyDao;
    private AuditDao auditDao;

    public ServiceLayerImpl(ItemDao itemDao, MoneyDao moneyDao, AuditDao auditDao) {
        this.itemDao = itemDao;
        this.moneyDao = moneyDao;
        this.auditDao = auditDao;
    }
    
    
    @Override
    public void addMoney(BigDecimal money) throws PersistenceException{
        moneyDao.addMoney(money);
        
//        auditDao.writeAuditEntry("Money " + money + " CREATED");
    }

    @Override
    public BigDecimal returnMoney(BigDecimal money) throws PersistenceException{
        BigDecimal bob = moneyDao.returnMoney(money);
//        auditDao.writeAuditEntry("Money " + money + " RETURNED");
        return bob;
        
    }

    @Override
    public List<BigDecimal> listMoney() throws PersistenceException{
        return moneyDao.listMoney();
    }

    @Override
    public BigDecimal calculateTotalMoney() throws PersistenceException{
        return moneyDao.calculateTotalMoney();
    }
    
    @Override
    public Item addItem(String itemId, Item item) throws PersistenceException{
//        auditDao.writeAuditEntry("ITEM " + item.getItemId() + "::" + item.getItemName() + "::" + item.getItemPrice() + "::" + item.getQuantity() + " UPDATED");
        return itemDao.addItem(itemId, item);
    }
    
    @Override
    public List<Item> getAllItemsAvailable() throws PersistenceException{
        return itemDao.getAllItemsAvailable();
    }
    
    @Override
    public List<Item> checkInventory(List<Item> itemList) throws PersistenceException{
        return itemDao.checkInventory(itemList);
    } 
    
    @Override
    public Item dispenseItem(Item item) throws PersistenceException{
        return itemDao.dispenseItem(item);
    }
    
    @Override
    public Item decrementInventory(Item item) throws PersistenceException{
        return itemDao.decrementInventory(item);
    }
    
//    @Override
//    public List<Item> minusQuantity(List<Item> itemList)
//            throws PersistenceException {
//        return itemDao.minusQuantity(itemList);
//    }
    
    
    @Override
    public Change coinChange(BigDecimal total) {                ///************in Service Layer b/c its not saving any information, it just does the calculation output
//        List<BigDecimal> coinChange = new ArrayList<>();
        
        BigDecimal quarter = new BigDecimal("25");
        BigDecimal dime = new BigDecimal("10");
        BigDecimal nickel = new BigDecimal("5");
        BigDecimal penny = new BigDecimal("1");
        int countQuarters = 0;
        int countDimes = 0;
        int countNickels = 0;
        int countPennies = 0;
        
        while(total.compareTo(quarter)==0||total.compareTo(quarter)==1){
//            coinChange.add(quarter);
            total = total.subtract(quarter);    
            countQuarters++;
        }
        while(total.compareTo(dime)==0||total.compareTo(dime)==1){
            total = total.subtract(dime);    
            countDimes++;
        }
        while(total.compareTo(nickel)==0||total.compareTo(nickel)==1){
           total = total.subtract(nickel);    
            countNickels++;
        }
        while(total.compareTo(penny)==0||total.compareTo(penny)==1){
            total = total.subtract(penny);    
            countPennies++;
        }
        
        Change mychange = new Change();
        mychange.setQuarter(countQuarters);
        mychange.setDime(countDimes);
        mychange.setNickel(countNickels);
        mychange.setPenny(countPennies);
        
       
        return mychange;
        
        
    }
    
    
    @Override
    public boolean areFundsEnough(Item item) throws
            InsufficientFundsException,
            PersistenceException {

        String message = "\nInsufficient Funds";
        BigDecimal cost = item.getItemPrice();
        BigDecimal cash = calculateTotalMoney();

        boolean sufficient = cash.compareTo(cost) >= 0;

        if (sufficient) {
            return true;
        } else {
            throw new InsufficientFundsException(message);
        }
    }
    
    @Override
    public boolean isStocked(Item item) throws
            NoItemInventoryException {

        String message = "\n" + item.getItemName()+ ": Not in Stock";

        boolean inStock = item.getQuantity() > 0;

        if (inStock) {
            return true;
        } else {
            throw new NoItemInventoryException(message);
        }
    }
}
