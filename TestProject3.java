import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.*;
import java.lang.reflect.Array;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class TestProject3 {
    public static void populateArrayWithRandom(int [] pArray) {
        Random randomNum = new Random();
        for(int i = 0; i < pArray.length; i++) {
            int randomNumber = randomNum.nextInt(10000);
            pArray[i] = randomNumber;
        }
    }

    public static void createTXT(String fName) {
        try {
            File file1 = new File (fName + ".txt");
            if (file1.createNewFile()) {
                System.out.println("File created: " + file1.getName());
            } else {
                System.out.println(" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public static void writeLinkedList(LinkedList<Integer> pArray, String filename) {
        try {
            FileWriter wr = new FileWriter(filename + ".txt");
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

    public static void writeArrayList(ArrayList <Long> pArray, String filename) {
        try {
            FileWriter wr = new FileWriter(filename + ".txt");
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

    public static void writeArrayListToCSV(ArrayList <Long> pArray, String filename) {
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

    public static void writeSizeToCSV(ArrayList <Integer> pArray, String filename) {
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



//------------------------------------------------------------------------------------------------

    public static void main(String[] args) {

        //filenames
        String filename = "selectionResults";

        //storage of results -ArrayList makes this computationally more expensive-replace with arrays
        ArrayList<Long> bubbleResults = new ArrayList<>();
        ArrayList<Long> selectionResults = new ArrayList<>();
        ArrayList<Long> mergeResults = new ArrayList<>();
        ArrayList <Integer> sizeOfArray = new ArrayList<>();

        //SetUp
        int limit = 20000;
        int increment = 100;
        long timeTaken = 0;
        long timeAfter = 0; long timeBefore = 0;

        //objects
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        MergeSort mergeSort = new MergeSort();

        //loop
        for (int size = 100; size < limit; size = size + increment) {

            //base case
            int[] numArray = new int[size];
            populateArrayWithRandom(numArray);

            //duplicates so each sort is on the same data
            int[] bubbleArray = new int[size];
            bubbleArray = numArray;
            int[] selectionArray = new int[size];
            selectionArray = numArray;
            int[] mergeArray = new int[size];
            mergeArray = numArray;

            //BubbleSort
            timeBefore = System.nanoTime();
            bubbleSort.doSort(bubbleArray);
            timeAfter = System.nanoTime();
            timeTaken = timeAfter - timeBefore;
            bubbleResults.add(timeTaken);

            //SelectionSort
            timeBefore = System.nanoTime();
            selectionSort.doSort(selectionArray);
            timeAfter = System.nanoTime();
            timeTaken = timeAfter - timeBefore;
            selectionResults.add(timeTaken);

            //MergeSort
            timeBefore = System.nanoTime();
            mergeSort.doSort(mergeArray, 0, mergeArray.length - 1);
            timeAfter = System.nanoTime();
            timeTaken = timeAfter - timeBefore;
            mergeResults.add(timeTaken);


            //increase size
            sizeOfArray.add(size);
            System.out.println(size);
        }

        //stick it in excel
        createCSV(filename);
        writeArrayListToCSV(selectionResults,filename);
        filename = "mergeResults";
        createCSV(filename);
        writeArrayListToCSV(mergeResults,filename);
        filename = "bubbleResults";
        createCSV(filename);
        writeArrayListToCSV(bubbleResults,filename);
        filename = "sizeOfArray";
        createCSV(filename);
        writeSizeToCSV(sizeOfArray,filename);
    }
}