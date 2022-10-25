/**
 * Author Tomio Nagano
 * Student number 300239414
 */

import java.io.IOException;
import java.util.Scanner;

public class Dynamic {

    /**
     * Controller method that executes the program
     * @param filename the filename of the input/output text files
     * @throws IOException
     */
    public void run(String filename) throws IOException {
        //actions involved with reading the data from the input.txt file
        Reader reader = new Reader();
        Item[] items=reader.readItems(filename);
        int capacity=reader.readSize(filename);

        //actions involved with creating the Ktable and saving the result
        KTable ktable=new KTable(capacity,items.length);
        ktable.fillTable(capacity,items);
        Knapsack result=ktable.getFinalKnapsack();

        //actions involved with printing the result to the .sol file
        Printer printer=new Printer();
        printer.printAnswer(filename,String.valueOf(result.getValue()),result.getItemsArray());
    }


    //would be used to get input via the keyboard
    //ngl I was confused how to get the input and made this, I'll leave it just in case
    private String getInput(){
        Scanner console = new Scanner(System.in);
        System.out.println("Please provide the name of the file with the information:");
        String filename = console.nextLine();
        System.out.println("Thank you");
        System.out.println("Next, please indicate whether you would like the problem solved using brute force by entering (F)," +
                " or if you would like it solved dynamically by pressing (D).");
        String method = console.nextLine();
        return filename;
    }



}

