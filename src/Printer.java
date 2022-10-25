/**
 * Author Tomio Nagano
 * Student number 300239414
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Printer {

    /**
     *
     * @param filename
     * @param sum
     * @param items
     * @throws IOException
     */
    public void printAnswer(String filename, String sum, Item[] items) throws IOException {
        File file= buildFile(getNameFromPath(filename));
        FileWriter writer=new FileWriter(file);
        writer.write(sum+"\n"+formatItems(items));
        writer.close();
    }

    /**
     * Helper method for printAnswer
     * Since a filePath instead of a filename would be a valid input this ensures that either way the name will be appropriate
     * @param filename
     * @return
     */
    private String getNameFromPath(String filename){
        String[] path=filename.split("\\\\");
        String[] name=path[path.length-1].split("\\.");
        return name[0]+".sol";
    }

    /**     *
     * @param items
     * @return a printable string in the desired format
     */
    private String formatItems(Item[] items){
        String result="";
        for (Item item:items) {
            result+=item.getName()+" ";
        }
        return result.strip();
    }

    /**
     * builds the .sol file we want as the output
     * @param filename name of the output file
     * @return the file
     */
    private File buildFile(String filename){
        File file = new File(filename);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                return file;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return file;

    }

}
