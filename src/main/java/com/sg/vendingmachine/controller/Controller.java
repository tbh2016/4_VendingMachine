 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;


import com.sg.vendingmachine.dao.PersistenceException;
import com.sg.vendingmachine.ui.View;
import java.math.BigDecimal;
import com.sg.vendingmachine.dto.Item;
import java.util.List;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.servicelayer.InsufficientFundsException;
import com.sg.vendingmachine.servicelayer.ServiceLayer;

/**
 *
 * @author THUAN HUYNH
 */
public class Controller {

ServiceLayer service;    
View view;    


    public Controller(ServiceLayer service, View view) {
        this.service = service;
        this.view = view;
        
    }


    
    public void run() {             //run method that uses another method on the bottom, which orchestrates whatever is in the view
        boolean keepGoing = true;
        int menuSelection = 0;
        try {        //The try statement lets you test a block of code for errors.
            //The catch statement lets you handle the error.

            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        insertMoney();
                        break;
                    case 2:
                        returnMoney();
                        break;
                    case 3:
                        displayMoney();
                        break;
                    case 4: 
                        buyItems();
                        break;
                    case 5:
                        hiddenAddItem();
                        break;
                    case 6:    
                        exitMessage();
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
        } catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection(); 
    }
    //**********************************************************************************************************
   
    private void insertMoney() throws PersistenceException {          
        view.displayInsertMoneyBanner();
        
        BigDecimal bdmoney = view.getNewMoney();
        
        
        service.addMoney(bdmoney);
        
        view.machineReceived(bdmoney);
    }

    //**********************************************************************************************************
    private void returnMoney() throws PersistenceException {       //method that will get list of dvds in the system
       view.displayReturnMoneyBanner();
       
       BigDecimal calculate = service.calculateTotalMoney();    //gets the current amount of money that I currently have - big decimal
        
       view.totalChange(calculate);
       
        Change userChange = service.coinChange(calculate);      //uses the coinChange method to return "int" number of coins and is saved in an object
        
        view.myChange(userChange);  //get the stored amount of coins and displays it to the user
        
        BigDecimal remaining = service.returnMoney(calculate);
        
        view.DisplayMachineAmount(remaining);
       
    }
    
    //**********************************************************************************************************
    private void displayMoney() throws PersistenceException {
        view.displayMoney();
        
        BigDecimal calculate = service.calculateTotalMoney();
        
        view.DisplayAmountInput(calculate);
        
        
//        List<BigDecimal> viewArray = dao.listMoney();
//        BigDecimal calculate = dao.calculateTotalMoney(viewArray);
//        dao.returnMoney();
    }
    //**********************************************************************************************************
    

    private void buyItems() throws PersistenceException, InsufficientFundsException {
        
//        try{********************************************************************************
        view.DisplayItems();
        List<Item> seeFruits = service.getAllItemsAvailable();
        List<Item> availableItems = service.checkInventory(seeFruits);  //check inventory and removes whatever is a 0 quantity
        int choice = view.displayFruitList(availableItems); //display the fruit list to the user
        
        service.listMoney();    //list array of money
        BigDecimal bdmoney = service.calculateTotalMoney(); //take array of money and change it to one total sum
        
        //Display my pick/choice 
        Item userItemChoice = availableItems.get(choice-1); //take user input from the view 
        
        
//        service.areFundsEnough(userItemChoice);
        
        if(bdmoney.compareTo(userItemChoice.getItemPrice()) == -1 ){
            view.DisplayNotEnoughMoney(userItemChoice.getItemPrice());
        } else {
           //minus cost of fruit from my current money
        //step 1 -- get BigDecimal of total money
        List<BigDecimal> list = service.listMoney();
        //step 2 -- get BigDecimal of totalmoney - item price
        BigDecimal total = service.calculateTotalMoney().subtract(userItemChoice.getItemPrice());
        //step 3 -- clear the money array in the dao
        service.returnMoney(total);
        //step 4 -- put the BigDecimal from step 2 into the money array
        service.addMoney(total);
        //finsih !
        
          
//        service.minusQuantity(seeFruits);****************************************************
        
        
        view.DisplayRemainingAmount(total);
        view.DisplayYouBought(userItemChoice.getItemName()); 
        }
        
        Item item =service.dispenseItem(userItemChoice);
        item = service.decrementInventory(item);
        service.addItem(item.getItemId(), item);
        
//        } catch(InsufficientFundsException | NoItemInventoryException e){******************
//            view.DisplayInsufficientFunds(e.getMessage());**********************************
//        }
    }

    //**********************************************************************************************************
    

    private void hiddenAddItem() throws PersistenceException {
        view.merchandiserAccessDisplay();
        Item newItem = view.addNewItems();
        service.addItem(newItem.getItemId(), newItem);
        view.displayCreateSuccessBanner();
    }
    
    private void unknownCommand() {         //BANNER FOR UNKNOWN 
        view.displayUnknownCommandBanner(); //calls method that print 
    }

    private void exitMessage() {        //BANNER FOR EXIT
        view.displayExitBanner();   //calls method that prints
    }

}
   