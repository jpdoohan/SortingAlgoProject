import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CSVTest {
    public static void createCSV(String fName) {
        try {
            File file1 = new File (fName + ".csv");
            if (file1.createNewFile()) {
                System.out.println("File created: " + file1.getName());
            } else {
                System.out.println(" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeArrayList(ArrayList<String> pArray, String filename) {
        try {
            FileWriter wr = new FileWriter(filename + ".csv");
            BufferedWriter bf = new BufferedWriter(wr); //wrapping
            PrintWriter writer = new PrintWriter(bf);


            for (int i = 0; i < pArray.size(); i++) {
                writer.println(pArray.get(i));
            }


            writer.close(); //closing from last opened back the way
            bf.close();
            wr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "TestCSV";
        createCSV(filename);
        ArrayList<String> testArray = new ArrayList<>();
        testArray.add("This");
        testArray.add("is");
        testArray.add("a");
        testArray.add("test");
        writeArrayList(testArray,filename);
    }
}
