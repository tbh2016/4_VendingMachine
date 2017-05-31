/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author THUAN HUYNH
 */
public class Item {
   
    
    
    private String itemId;
    private String itemName;
    private BigDecimal itemPrice;
    private int quantity; 

    

    public Item(String itemId) {
        this.itemId = itemId;
    }
    
    
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString(){
        return "ID: " + itemId + " |Name: " + itemName + " |Price: " +  itemPrice 
                + " |Quantity: " + quantity;
                
    }
    
    
    
}
