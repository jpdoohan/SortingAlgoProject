import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.*;
import java.lang.reflect.Array;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class TestProject4 {
    static int menuStatus = 0;
    static int dataSize = 0;
    static boolean unsorted = true;
    static int size = 1000;
    static int limit = 20000;
    static int increment = 100;

    public static void populateArrayWithRandom(int[] pArray) {
        Random randomNum = new Random();
        for (int i = 0; i < pArray.length; i++) {
            int randomNumber = randomNum.nextInt(10000);
            pArray[i] = randomNumber;
        }
    }

    public static void createTXT(String fName) {
        try {
            File file1 = new File(fName + ".txt");
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
            File file1 = new File(fName + ".csv");
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

    public static void writeArrayList(ArrayList<Long> pArray, String filename) {
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

    public static void writeArrayListToCSV(ArrayList<Long> pArray, String filename) {
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

    public static void writeSizeToCSV(ArrayList<Integer> pArray, String filename) {
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

    //menu methods

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-Sorting Algorithm Analysis-");
        System.out.println("Select sorting type:\n1. For selection sort.\n2. For Quick sort.\n3. For Merge Sort.\n4. For All\n-1. Exit.");
        menuStatus = scanner.nextInt();
        if (menuStatus != -1) {
            System.out.println("---");
            System.out.println("Select data size:\n1. Small\n2. Medium\n3. Large\n-1. Exit.");
            setDataSize(scanner.nextInt());
            if (menuStatus != -1) {
                System.out.println("---");
                System.out.println("Data is unsorted by default. Would you like to test with sorted data?");
                System.out.println("Enter: \n1. For Unsorted data\n2. For Sorted data\n-1. Exit.");
                int response = scanner.nextInt();
                if (response != -1) {
                    setSortedOrUnsorted(response);
                }
                menuStatus = 1;
            }
        }
    }

    //set datasize
    public static void setDataSize(int userInput) {
        if(userInput ==1) {
        size = 10;
        limit = 1000;
        increment = 10;
    }
        else if(dataSize ==2)
    {
        size = 1000;
        limit = 10000;
        increment = 100;
    }
        else if(dataSize ==3)
    {
        size = 10000;
        limit = 100000;
        increment = 1000;
    }
        else if(dataSize == 5)
    {
        size = 10000;
        limit = 750000;
        increment = 10000;
    }
        else if(dataSize ==-1)

    {
        menuStatus = -1;
    } else
    {
        System.out.println("Input incorrect, please choose 1, 2 or 3.");
        menuStatus = 0;
    }
}

    public static void setSortedOrUnsorted(int userInput) {
        if (userInput == 1) {
        } else if (userInput == 2) {
            unsorted = false;
        } else {
            System.out.println("Input incorrect, please choose 1 or 2.");
            menuStatus = 0;
        }
    }

    public static void sortedOrUnsortedMechanism(int [] pArray){
        if (unsorted = true) {
            populateArrayWithRandom(pArray);
        } else {
            for (int i = 0; i < pArray.length; i++) {
                pArray[i] = i + 1;
            }
        }
    }

    public static void sortingMethod(ArrayList<Long> pResults,ArrayList <Integer> pSizeOfArray, SelectionSort pSort) {
        //SetUp
        long timeTaken = 0;
        long timeAfter = 0;
        long timeBefore = 0;

        //loop
        for (int i = size; size < limit; size = size + increment) {

            //base case
            int[] numArray = new int[size];
            sortedOrUnsortedMechanism(numArray);

            //duplicates so each sort is on the same data
            int[] selectionArray = new int[size];
            selectionArray = numArray;

            //SelectionSort
            timeBefore = System.nanoTime();
            pSort.doSort(selectionArray);
            timeAfter = System.nanoTime();
            timeTaken = timeAfter - timeBefore;
            pResults.add(timeTaken);

            //increase size
            pSizeOfArray.add(size);
            System.out.println(size);
        }
    }

    public static void sortingMethod(ArrayList<Long> pResults,ArrayList <Integer> pSizeOfArray, MergeSort pSort) {
        //SetUp
        long timeTaken = 0;
        long timeAfter = 0;
        long timeBefore = 0;

        //loop
        for (int i = size; size < limit; size = size + increment) {

            //base case
            int[] numArray = new int[size];
            sortedOrUnsortedMechanism(numArray);

            //duplicates so each sort is on the same data
            int[] mergeArray = new int[size];
            mergeArray = numArray;

            //MergeSort
            timeBefore = System.nanoTime();
            pSort.doSort(mergeArray,0, mergeArray.length - 1);
            timeAfter = System.nanoTime();
            timeTaken = timeAfter - timeBefore;
            pResults.add(timeTaken);

            //increase size
            pSizeOfArray.add(size);
            System.out.println(size);
        }
    }

    public static void sortingMethod(ArrayList<Long> pResults,ArrayList <Integer> pSizeOfArray, BubbleSort pSort) {
        //SetUp
        long timeTaken = 0;
        long timeAfter = 0;
        long timeBefore = 0;

        //loop
        for (int i = size; size < limit; size = size + increment) {

            //base case
            int[] numArray = new int[size];
            sortedOrUnsortedMechanism(numArray);

            //duplicates so each sort is on the same data
            int[] bubbleArray = new int[size];
            bubbleArray = numArray;

            //BubbleSort
            timeBefore = System.nanoTime();
            pSort.doSort(bubbleArray);
            timeAfter = System.nanoTime();
            timeTaken = timeAfter - timeBefore;
            pResults.add(timeTaken);

            //increase size
            pSizeOfArray.add(size);
            System.out.println(size);
        }
    }

    public static void sortingMethod(BubbleSort pBubbleSort, SelectionSort pSelectionSort, MergeSort pMergeSort,
                                     ArrayList<Long> pBubbleResults,ArrayList<Long> pSelectionResults,ArrayList<Long> pMergeResults,
                                     ArrayList <Integer> pSizeOfArray) {
        //SetUp
        long timeTaken = 0;
        long timeAfter = 0;
        long timeBefore = 0;

        //loop
        for (int i = size; i < limit; i = i + increment) {
            //base case
            int[] numArray = new int[size];
            sortedOrUnsortedMechanism(numArray);

            //duplicates so each sort is on the same data
            int[] selectionArray = new int[size];
            selectionArray = numArray;
            int[] mergeArray = new int[size];
            mergeArray = numArray;
            int[] bubbleArray = new int[size];
            bubbleArray = numArray;

            //SelectionSort
            timeBefore = System.nanoTime();
            pSelectionSort.doSort(selectionArray);
            timeAfter = System.nanoTime();
            timeTaken = timeAfter - timeBefore;
            pSelectionResults.add(timeTaken);

            //MergeSort
            timeBefore = System.nanoTime();
            pMergeSort.doSort(mergeArray, 0, mergeArray.length - 1);
            timeAfter = System.nanoTime();
            timeTaken = timeAfter - timeBefore;
            pMergeResults.add(timeTaken);

            //QuickSort
            timeBefore = System.nanoTime();
            pBubbleSort.doSort(bubbleArray);
            timeAfter = System.nanoTime();
            timeTaken = timeAfter - timeBefore;
            pBubbleResults.add(timeTaken);

            //increase size
            pSizeOfArray.add(size);
            System.out.println(size);
        }
    }

    public static void writeFiles(String fileName1,ArrayList<Long> pResults,ArrayList <Integer> pSizeOfArray) {
        String filename;
        filename = fileName1;
        createCSV(filename);
        writeArrayListToCSV(pResults, filename);
        filename = "sizeOfArray";
        createCSV(filename);
        writeSizeToCSV(pSizeOfArray, filename);
    }

    public static void writeFiles(ArrayList<Long> pBubbleResults, ArrayList<Long> pSelectionResults,ArrayList<Long> pMergeResults, ArrayList <Integer> pSizeOfArray) {
        String filename;
        filename = "bubbleResults";
        createCSV(filename);
        writeArrayListToCSV(pBubbleResults, filename);
        filename = "selectionResults";
        createCSV(filename);
        writeArrayListToCSV(pSelectionResults, filename);
        filename = "mergeResults";
        createCSV(filename);
        writeArrayListToCSV(pMergeResults, filename);
        filename = "sizeOfArray";
        createCSV(filename);
        writeSizeToCSV(pSizeOfArray, filename);
    }





    //------------------------------------------------------------------------------------------------

    public static void main(String[] args) {

        //filenames
        String filename = "selectionResults";

        //storage of results -ArrayList makes this computationally more expensive-replace with arrays
        ArrayList<Long> selectionResults = new ArrayList<>();
        ArrayList<Long> mergeResults = new ArrayList<>();
        ArrayList<Long> bubbleResults = new ArrayList<>();
        ArrayList<Integer> sizeOfArray = new ArrayList<>();

        //objects
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        MergeSort mergeSort = new MergeSort();


        //Program runs -- user control
        while (menuStatus == 0) {
            menu();
            //algo type
            if (menuStatus == 1) {
                //loop
                sortingMethod(selectionResults, sizeOfArray, selectionSort);
                filename = "selectionSort";
                writeFiles(filename, selectionResults, sizeOfArray);
            } else if (menuStatus == 2) {
                //loop
                sortingMethod(bubbleResults, sizeOfArray, bubbleSort);
                filename = "bubbleResults";
                writeFiles(filename, bubbleResults, sizeOfArray);
            } else if (menuStatus == 3) {
                //loop
                sortingMethod(mergeResults, sizeOfArray, mergeSort);
                filename = "mergeResults";
                writeFiles(filename, mergeResults, sizeOfArray);

            } else if (menuStatus == 4) {
                //loop
                sortingMethod(bubbleSort, selectionSort,mergeSort,selectionResults,mergeResults,bubbleResults,sizeOfArray);
                writeFiles(bubbleResults,selectionResults,mergeResults,sizeOfArray);

            } else if (menuStatus == -1) {
                System.out.println("Thank you for using\n-Sorting Algorithm Analysis-");
                break;
            } else {
                System.out.println("Input incorrect, please choose 1,2,3 or 4.");
            }
            menuStatus = 0;
        }
    }
}

