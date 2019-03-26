package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FulfillmentCenterContainer {


    Map< String, FulFillmentCenter > warehouses = new HashMap<>();

    public void addCenter( String nameOfContainer, double maximumCapacityOfContainer){
        FulFillmentCenter warehouse1 = new FulFillmentCenter(nameOfContainer,maximumCapacityOfContainer);
        warehouses.put(nameOfContainer, warehouse1);
    }

    public void removeCenter( String nameOfContainer ){
        if(warehouses.containsKey(nameOfContainer)){
            warehouses.remove(nameOfContainer);
        }
        else{
            System.out.println("Can not delete object that not exist");
        }

    }
    public void summary(){
        for( FulFillmentCenter object : warehouses.values() ){
            double procentOfFillment = (( object.weightList / object.maximumWeithOfProducts )*100);
            System.out.println(" Name of ware house is " + object.nameOfWareHouse + " Prodent of fulfillment is " + procentOfFillment + "%");

        }

    }

    public List<FulFillmentCenter> findEmpty() {
        List< FulFillmentCenter > howManyEmpty = new ArrayList<>();
        for ( FulFillmentCenter object : warehouses.values() ){
            if( object.weightList == 0 ){
                howManyEmpty.add(object);
            }
        }
        return howManyEmpty;
    }

}

