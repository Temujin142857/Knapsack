/**
 * Author Tomio Nagano
 * Student number 300239414
 */

import java.io.*;
import java.util.ArrayList;

public class Reader {
    private FileReader reader;

    public int readSize(String filename) throws IOException {
        String size = null;
        reader=new FileReader(filename);
        BufferedReader br =new BufferedReader(reader);
        while (br.ready()){
            size=br.readLine();
        }
        br.close();
        reader.close();
        return Integer.parseInt(size);
    }


    public Item[] readItems(String filename) throws IOException {
        ArrayList<Item> items=new ArrayList<>();
        reader=new FileReader(filename);
        BufferedReader br =new BufferedReader(reader);
        items.add(new Item("Empty",0,0));

        while (br.ready()){
            String line=br.readLine();
            char[] data=line.toCharArray();
            if (Character.isDigit(data[0])){continue;}
            items.add(new Item(String.valueOf(data[0])));
            String weight="";
            String value="";
            int i=2;
            while(data[i]!=' '){
                value+=data[i];
                i++;
            }
            items.get(items.size()-1).setValue(Integer.parseInt(value));
            i++;
            while(i<data.length){
                weight+=data[i];
                i++;
            }
            items.get(items.size()-1).setWeight(Integer.parseInt(weight));
        }

        br.close();
        reader.close();
        return items.toArray(new Item[items.size()]);
    }
}
