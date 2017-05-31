/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Money;

/**
 *
 * @author THUAN HUYNH
 */
public class View {
    //UserIO io = new UserIOConsoleImpl();
     private UserIO io;

    public View(UserIO io) {
        this.io = io;
    }
    
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Insert Money");
        io.print("2. Return Money");
        io.print("3. Display Money");
        io.print("4. Buy Item");
        io.print("5. MERCHANDISER ACCESS - REQUIRES A KEY");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    //******************************************************************************       

    public Item addNewItems(){
        String itemId = io.readString("Please enter food id: ");
        String name = io.readString("Please enter food name: ");
        String price = io.readString("Please enter price: ");
        int quantity = io.readInt("Please enter the quantity: ");
        BigDecimal bdprice = new BigDecimal(price);
        Item currentItem = new Item(itemId);
        currentItem.setItemName(name);
        currentItem.setItemPrice(bdprice);
        currentItem.setQuantity(quantity);
        return currentItem;
    }
    
    public BigDecimal getNewMoney(){
        String money = io.readString("How much cents do you want to input: ");
        BigDecimal bdmoney = new BigDecimal(money);
        return bdmoney; 
    }
    
    public void getReturnMoney(){
        
        io.print("=== Money Returned ===");
    }
    
    public void displayReturnMoneyBanner(){
        io.print("=== Return Money ===");
    }
        
    public void displayMoney(){
        io.print("=== Money in Machine ===");
    }
    public void displayReturnMoney(BigDecimal calculate){
        io.print("The machine refunded you $"+ calculate + ".");
    }
    
    
    public void displayInsertMoneyBanner() {
        io.print("=== Insert Money ===");
    }

//    public void DisplayMoneyInserted() {
//        BigDecimal print = dao.addMoney();
//        io.print("You have " + + " in the machine.")
//    }

    public void DisplayItems() {
        io.print("=== Items to Buy ===");
    }

    
    public void merchandiserAccessDisplay() {
        io.print("=== MERCHANDISER ACCESS - ADD YOUR FRUITS ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.enterToContinue(
                "Fruit successfully added into vending machine data.Please hit enter to continue");
    }
    
    public int displayFruitList(List<Item> fruitList) { //this is a method to list fruit object as a parameter and display the information for each fruit to the screen
        int count = 1;
        for (Item currentFruit : fruitList) {
            io.print(count + ": "
                    + currentFruit.getItemName() + " "
                    + currentFruit.getItemPrice() + " "
                    + currentFruit.getQuantity());
            count++;
        }
        return io.readInt("Please hit enter to continue.", 1, fruitList.size()); //will pause and wait for user to hit enter key
    }
     
     
     
 //******************************************************************************           
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
    public void displayUnknownCommandBanner() {
        io.print("unknown");
    }
    
    public void displayExitBanner() {
        io.print("goodbye");
    }
    
   
    public void machineReceived(BigDecimal bob){
        io.print("The machine received your " + bob + " cents" +"\n");
    }
    
    public void totalChange(BigDecimal money){
        io.print("Your return amount is " + money + " cents");
    }
    
    public Change myChange(Change count){
    
        io.print("Your change in quarters is: " + count.getQuarter());
        
        io.print("Your change in dimes is: " + count.getDime());
        
        io.print("Your change in nickelss is: " + count.getNickel());
        
        io.print("Your change in pennies is: " + count.getPenny());
        
        return count;
    }
    
     public void DisplayMachineAmount(BigDecimal zero){
        io.print("The amount in the machine is now " + zero + " cents" + "\n");
    }
   
    public void DisplayAmountInput(BigDecimal calculate){
        io.print("The amount you have inputted is " + calculate + " cents" + "\n");
    }
   
    public void DisplayNotEnoughMoney(BigDecimal itemPrice){
        io.print("You do not have enough money.You need to input " +  itemPrice + "\n");
    }
    
    public void DisplayRemainingAmount(BigDecimal total){
        io.print("Your remaining amount is: " + total); 
    }
    
    public void DisplayYouBought(String item){
        io.print("You bought a " + item + "\n");
    }
}

    