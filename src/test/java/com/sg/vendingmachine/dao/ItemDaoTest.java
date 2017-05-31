///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sg.vendingmachine.dao;
//
//import com.sg.vendingmachine.dto.Item;
//import com.sg.vendingmachine.servicelayer.ServiceLayer;
//import com.sg.vendingmachine.servicelayer.ServiceLayerImpl;
//import java.math.BigDecimal;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author yingy
// */
//public class ItemDaoTest {
//    ItemDao dao = new ItemDaoImpl();
//    ServiceLayer layer = new ServiceLayerImpl();
//    
//    public ItemDaoTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//
//        
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of addItem method, of class ItemDao.
//     */
//    @Test
//    public void testAddItem() throws Exception {
//        
//    }
//
//    /**
//     * Test of getAllItemsAvailable method, of class ItemDao.
//     */
//    @Test
//    public void testGetAllItemsAvailable() throws Exception {
//        
//        Item item = new Item("001");
//        item.setItemName("Grape");
//        item.setItemPrice(new BigDecimal("10"));
//        
//        dao.addItem(item.getItemId(), item);
//        
//        Item item2 = new Item("002");
//        item.setItemName("Du");
//        item.setItemPrice(new BigDecimal("10"));
//        
//        dao.addItem(item2.getItemId(), item);
//        
//        assertEquals(12, dao.getAllItemsAvailable().size());
//    }
//
//    
//    
//    
//}
