import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SortingAlgorithm {

    //variables
    int swaps;
    int comparisons;
    int [] data;
    long timeTaken;

    //constructors
    public SortingAlgorithm() {
        //default
    }

    public SortingAlgorithm(int [] pData) {
        data = pData;
    }

    //methods
    //0. Getters/Setters
    public int getSwaps() {
        return swaps;
    }

    public int getComparisons() {
        return comparisons;
    }

    public void setSwaps(int pSwaps) {
        swaps = pSwaps;
    }

    public void setComparisons(int pComparisons) {
        comparisons = pComparisons;
    }

    //1. input/output

    //1.A) Writing to files
    protected void writeArrayToTXT(int [] pArray, String filename) {
        try {
            FileWriter wr = new FileWriter(filename + ".txt");
            BufferedWriter bf = new BufferedWriter(wr); //wrapping
            PrintWriter writer = new PrintWriter(bf);
            for (int i = 0; i < pArray.length; i++) {
                writer.println(pArray[i]);
            }
            writer.close(); //closing from last opened back the way
            bf.close();
            wr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
