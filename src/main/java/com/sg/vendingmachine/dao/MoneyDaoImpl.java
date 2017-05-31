/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;import java.util.Scanner;

import java.util.Scanner;

/**
 *
 * @author yingy
 */
public class MoneyDaoImpl implements MoneyDao {

    

    private List<BigDecimal> money = new ArrayList<>();
    public BigDecimal loadedMoney = new BigDecimal("0");
    public static final String MONEY_FILE = "money.txt";

    @Override
    public void addMoney(BigDecimal coins) throws PersistenceException {
       loadedMoney= loadedMoney.add(coins);
       writeVMTextMoney();
    }

    @Override
    public BigDecimal returnMoney(BigDecimal coins) throws PersistenceException {
        loadedMoney = new BigDecimal("0");
        writeVMTextMoney();
        return loadedMoney;
    }

    @Override
    public List<BigDecimal> listMoney() throws PersistenceException {
        return money;
    }

    @Override
    public BigDecimal calculateTotalMoney() throws PersistenceException {
        loadVMTextMoney();
        writeVMTextMoney();
        return loadedMoney;
    }


    private void loadVMTextMoney() throws PersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(MONEY_FILE)));
        } catch (FileNotFoundException e) {
            throw new PersistenceException(
                    "-_- Could not load vm data into memory.", e);
        }
        loadedMoney = scanner.nextBigDecimal();

        scanner.close();
    }


    private void writeVMTextMoney() throws PersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(MONEY_FILE));
        } catch (IOException e) {
            throw new PersistenceException(
                    "Could not save student data.", e);
        }
        String moneyString = loadedMoney.toString();
        out.println(moneyString);
        out.flush();
        out.close();
    }
}
