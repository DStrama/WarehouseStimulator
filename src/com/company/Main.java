package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import javax.swing.plaf.FontUIResource;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FulFillmentCenter ware1 = new FulFillmentCenter("Magazyn1", 2000.);
        Item objectone = new Item("iphone",ItemCondition.NEW, 22.1 ,1);
        Item objecttwo = new Item("laptop",ItemCondition.USED, 30.1 ,5);
        Item objectthree = new Item("tablet",ItemCondition.REFUBRISHED, 10.1 ,1);
        Item objectfour = new Item("iphone7",ItemCondition.USED, 23.1 ,1);


        ware1.addProduct(objectone);
        ware1.addProduct(objecttwo);
        ware1.addProduct(objectthree);
        ware1.addProduct(objectfour);

        System.out.println(ware1.max());

        System.out.println("--------------------");
        ware1.search("iphone");
        System.out.println("--------------------");
        ware1.getProduct(objecttwo);
        ware1.summary();
        System.out.println("--------------------");
        ware1.removeProduct(objectone);
        ware1.summary();
        System.out.println("--------------------");
        ware1.search("tablet").print();
        System.out.println("--------------------");

        System.out.println(ware1.searchPartial("tab"));

       // ware1.summary();
        System.out.println("--------------------");
        System.out.println(ware1.countByCondition(ItemCondition.USED));
        System.out.println("--------------------");
        System.out.println("sortuj po nazwie");
        ware1.sortByName();
        ware1.summary();
        System.out.println("--------------------");
        System.out.println("sortuj po ilosci");
        ware1.sortByAmount();
        ware1.summary();


        FulFillmentCenter ware2 = new FulFillmentCenter("Magazyn2", 200.);

        Item objectfive=new Item("dron",ItemCondition.NEW,1.5,2);
        Item obiectsix=new Item("mysz",ItemCondition.NEW,0.5,5);
        Item objectseven=new Item("monitor",ItemCondition.USED,5.0,1);
        Item objecteight=new Item("sluchawki",ItemCondition.REFUBRISHED,20.,3);

        ware2.addProduct(objectfive);
        ware2.addProduct(obiectsix);
        ware2.addProduct(objectseven);
        ware2.addProduct(objecteight);


        FulfillmentCenterContainer container = new FulfillmentCenterContainer();

        System.out.println("--------------------");
        container.warehouses.put("Magazyn 1", ware1);
        container.warehouses.put("Magazyn 2", ware2);
        container.summary();

        System.out.println("--------------------");
        container.addCenter("Magazyn4", 1000.);
        container.addCenter("Magazyn5", 632.);
        container.summary();
        System.out.println("--------------------");

        FulFillmentCenter ware3 = new FulFillmentCenter("Magazyn3", 200.);
        container.warehouses.put("Magazyn3", ware3);

        container.summary();
        container.removeCenter("Magazyn3");
        container.removeCenter("Magazyn3");
        System.out.println("--------------------");
        container.summary();

        System.out.println("--------------------");

        System.out.println(container.findEmpty());

    }


}


