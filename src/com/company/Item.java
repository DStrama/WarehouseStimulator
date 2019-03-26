package com.company;

public class Item implements Comparable<Item>{
    String name;
    ItemCondition condition;
    Double weight;
    int quantity;

    public Item(String name, ItemCondition condition, Double weight, int quantity) {
        this.name = name;
        this.condition = condition;
        this.weight = weight;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", condition=" + condition +
                ", weight=" + weight +
                ", quantity=" + quantity +
                '}';
    }

    public String print(){
        return "Name of item : " + name + " | " + "Quantity : " + quantity + " | " + "Weight : " + weight;

    }


    @Override
    public int compareTo(Item nazwaArg){
        return this.name.compareTo(nazwaArg.name);
        //String already implements Comparable so you don't need to do anything
        }
    }


