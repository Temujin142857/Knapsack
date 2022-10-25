/**
 * Author Tomio Nagano
 * Student number 300239414
 */

public class Item {
    private int value;
    private int weight;
    private String name;

    //It was sometimes more convenient to build an item with all the data at once
    // and sometimes to build it with just a name and add the rest later, so I made two constructors
    public Item(String name){
        this.name=name;
    }

    public Item(String name,int value,int weight){
        this.name=name;
        this.value=value;
        this.weight=weight;
    }


    public void setValue(int value) {
        this.value = value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }
}

