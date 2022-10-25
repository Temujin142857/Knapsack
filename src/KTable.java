/**
 * Author Tomio Nagano
 * Student number 300239414
 */

import java.util.ArrayList;

public class KTable {
    private Knapsack[][] knapsacks;

    /**
     * sets up the array of knapsacks, capacity+1 to account for the bag of capacity 0
     * @param capacity
     * @param numItems
     */
    public KTable(int capacity, int numItems){
        knapsacks=new Knapsack[capacity+1][numItems];
    }

    /**
     * Method fills the table based on the items and capacity provided
     * @param capacity capasity of the final knapsack
     * @param items all the options of items to put in the knapsack
     */
    public void fillTable(int capacity,Item[] items){
        for (int i = 0; i < capacity+1; i++) {//loops through the "columns" of the table
            for (int j = 0; j<items.length; j++) {//loops through the "rows" of the table
                knapsacks[i][j]= fillSack(i,j,items[j]);
            }
        }
    }

    /**
     * Helper method to fillTable, creates the knapsack for one cell of the table
     * based on the explanation from the assignment instructions
     * @param capacity capacity of the column of the table
     * @param itemLoc the location of the new item in the items array
     * @param item the new item
     * @return the knapsack for one cell of the table
     */
    private Knapsack fillSack(int capacity, int itemLoc, Item item){
        //handles the row and column of 0's
        if(capacity==0||itemLoc==0){return new Knapsack(0,0);}

        //handles the case where the item is larger than the capacity
        else if (item.getWeight()>capacity){return knapsacks[capacity][itemLoc-1];}

        //handles case where the value above this on the table is larger than the current item plus the appropriate cell in the last row
        else if (knapsacks[capacity][itemLoc-1].getValue()>=(knapsacks[capacity-item.getWeight()][itemLoc-1].getValue()+item.getValue())){
            return new Knapsack(knapsacks[capacity][itemLoc-1].getItemsList());
        }

        //handles the case where the value above this on the table is smaller than the current item plus the appropriate cell in the last row
        else {
            ArrayList<Item> sackWithNewItem= new ArrayList<Item>(knapsacks[capacity-item.getWeight()][itemLoc-1].getItemsList());
            for (Item i:sackWithNewItem) {
            }
            sackWithNewItem.add(item);
            return new Knapsack(sackWithNewItem);
        }
    }

    public Knapsack getFinalKnapsack(){
        return knapsacks[knapsacks.length-1][knapsacks[knapsacks.length-1].length-1];
    }


}
