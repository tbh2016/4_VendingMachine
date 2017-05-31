/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine;


import com.sg.vendingmachine.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author THUAN HUYNH
 */
public class App {

    public static void main(String[] args) {
//        UserIO myIo = new UserIOImpl();
//        View myView = new View(myIo); 
//        ItemDao itemDao = new ItemDaoImpl();
//        MoneyDao moneyDao = new MoneyDaoImpl();
//        AuditDao auditDao = new AuditDaoImpl();
//        ServiceLayer service = new ServiceLayerImpl(itemDao, moneyDao, auditDao);
//        Controller controller = new Controller(service, myView);
//        controller.run();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller = ctx.getBean("controller", Controller.class);
        controller.run();
    }
}

