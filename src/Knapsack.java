/**
 * Author Tomio Nagano
 * Student number 300239414
 */

import java.util.ArrayList;

public class Knapsack {
    private ArrayList<Item> items=new ArrayList<>();
    private int capacity;
    private int value=0;

    public Knapsack(int cap,int val){
        capacity=cap;
        value=val;
    }

    /**
     * builds a knapsack with the given items already inside
     * @param items
     */
    public Knapsack(ArrayList<Item> items){
        for (Item item:items) {
            this.items.add(item);
            value+=item.getValue();
            capacity-= item.getWeight();
        }

    }

    //returns the items as an array
    public Item[] getItemsArray(){
        return items.toArray(new Item[items.size()]);
    }

    //returns the items as an arraylist
    public ArrayList<Item> getItemsList(){
        return items;
    }

    public int getValue() {
        return value;
    }

    public int getCapacity() {
        return capacity;
    }
}
