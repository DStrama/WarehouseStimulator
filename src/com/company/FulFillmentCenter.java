package com.company;
import java.util.*;


public class FulFillmentCenter implements Comparator<Item>{
    String nameOfWareHouse;
    Double maximumWeithOfProducts;
    Double weightList = 0.0;
    List<Item> listOfProducts = new ArrayList();

    public FulFillmentCenter(String nameOfWareHouse, Double maximumWeithOfProducts) {
        this.nameOfWareHouse = nameOfWareHouse;
        this.maximumWeithOfProducts = maximumWeithOfProducts;
    }

    public static Comparator<Item> MaxComparator = (i1, i2) -> { //comparator for finding maximum quantity

        int amount1 = i1.quantity;
        int amount2 = i2.quantity;

        return Integer.compare(amount1, amount2);

    };

    public void addProduct(Item object2) {

        for ( Item object1 : listOfProducts ) {
            if (object1.compareTo(object2) == 0) {
                if (object2.weight * object2.quantity + weightList < maximumWeithOfProducts) {

                    object1.quantity = object1.quantity + object2.quantity;

                    weightList = weightList + object1.quantity * object2.weight;
                    return;
                } else {
                    System.err.println("Error maximum weight of the products has been exceeded ");
                    return;
                }
            }
        }
        if( object2.weight * object2.quantity + weightList <= maximumWeithOfProducts ){
                listOfProducts.add(object2);
                weightList = weightList + object2.weight*object2.quantity;

        }
        else{
                System.err.println("Error maximum weight of the products has been exceeded. You can not add new element ");
                return;
        }
        }

    public void removeProduct(Item object2){
        weightList = weightList - object2.quantity*object2.weight;
        listOfProducts.remove(object2);

    }

    public void getProduct(Item object2){
        for ( int i = 0 ; i < listOfProducts.size() ; i++){
            Item object1 = listOfProducts.get(i);
            if(object2.compareTo(object1) == 0){
                if((object2.quantity - 1) > 0){

                    double tmp = object2.weight/object2.quantity;
                    object2.quantity = object2.quantity - 1;

                    object2.weight = tmp*object2.quantity;
                }
                else if((object2.quantity - 1) == 0){

                    listOfProducts.remove(object2);

                }

            }

        }

    }



    public int countByCondition(ItemCondition con){

        int howMany = 0;
        for(Item object : listOfProducts ){
            if( object.condition == con){
                howMany++;
            }

        }
        return howMany;
    }

    public void summary() {
        for (Item item : listOfProducts) {
            System.out.println(item);

        }
    }

    public List<Item> sortByName(){
        List< Item > listSort = new ArrayList<>();
        Collections.sort(listOfProducts, this::compare);
        for( Item object : listOfProducts ){
            listSort.add(object);

        }
        return listSort;

    }

    public Item search(String searchItem ){
            for( Item object : listOfProducts ){
                if(object.name.equals(searchItem)){
                    System.out.println(object.name);
                    return object;
                }
            }
            System.err.println("Item not found");
            return null;
    }

    public List<Item> sortByAmount(){
        List < Item > listSortByAmount = new ArrayList<>();
        listSortByAmount = listOfProducts;
        Collections.sort(listOfProducts, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return -Integer.compare(o1.quantity, o2.quantity);
            }
        });
        return listSortByAmount;
    }

    public List < Item > searchPartial(String nameToSearch ){
        List < Item > list = new ArrayList<>();
        for( Item items : listOfProducts ){
            if( items.name.contains(nameToSearch) == true ){
                list.add(items);
            }

        }
        return list;
    }


    public Item max() {
        Item i1 = Collections.max(listOfProducts, FulFillmentCenter.MaxComparator);
        return i1;
    }

    @Override
    public int compare(Item object1, Item object2 ){
        return object1.name.compareTo(object2.name);

    }


    @Override
    public String toString() {
        return "FulFillmentCenter{" +
                "nameOfWareHouse='" + nameOfWareHouse + '\'' +
                ", maximumWeithOfProducts=" + maximumWeithOfProducts +
                ", weightList=" + weightList +
                ", listOfProducts=" + listOfProducts +
                '}';
    }
}


