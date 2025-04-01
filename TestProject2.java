import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.*;
import java.lang.reflect.Array;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class TestProject2 {
    static int menuStatus = 0;
    static int dataSize = 0;
    static int sortedOrUnsorted = 0;

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
        System.out.println("---");
        System.out.println("Select data size:\n1. Small\n2. Medium\n3. Large\n-1. Exit.");
        dataSize = scanner.nextInt();
        System.out.println("---");
        System.out.println("Select chaos: \n1. Unsorted data\n2. Sorted data\n-1. Exit.");
        sortedOrUnsorted = scanner.nextInt();
        menuStatus = 1;
    }



    //------------------------------------------------------------------------------------------------

    public static void main(String[] args) {

        //filenames
        String filename = "selectionResults";

        //storage of results -ArrayList makes this computationally more expensive-replace with arrays
        ArrayList<Long> selectionResults = new ArrayList<>();
        ArrayList<Long> mergeResults = new ArrayList<>();
        ArrayList<Long> quickResults = new ArrayList<>();
        ArrayList<Integer> sizeOfArray = new ArrayList<>();


        //SetUp
        int size = 1000;
        int limit = 20000;
        int increment = 100;
        long timeTaken = 0;
        long timeAfter = 0;
        long timeBefore = 0;

        //objects
        SelectionSort selectionSort = new SelectionSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();

        //Program runs -- user control
        while (menuStatus == 0) {
            menu();
            //datasize
            if (dataSize == 1) {
                size = 10;
                limit = 1000;
                increment = 10;
            } else if (dataSize == 2) {
                size = 1000;
                limit = 10000;
                increment = 100;
            } else if (dataSize == 3) {
                size = 10000;
                limit = 100000;
                increment = 1000;
            } else if (dataSize == -1) {
                menuStatus = -1;
                break;
        } else {
                System.out.println("Input incorrect, please choose 1, 2 or 3.");
                menuStatus = 0;
            }
            //sorted or unsorted
            if (sortedOrUnsorted == 1) {
            } else if (sortedOrUnsorted == 2) {
            } else {
                System.out.println("Input incorrect, please choose 1 or 2.");
                menuStatus = 0;
            }

            //algo type
            if (menuStatus == 1) {
                //loop
                for (int i = size; size < limit; size = size + increment) {

                    //base case
                    int[] numArray = new int[size];
                    populateArrayWithRandom(numArray);

                    //duplicates so each sort is on the same data
                    int[] selectionArray = new int[size];
                    selectionArray = numArray;

                    //SelectionSort
                    timeBefore = System.nanoTime();
                    selectionSort.doSort(selectionArray);
                    timeAfter = System.nanoTime();
                    timeTaken = timeAfter - timeBefore;
                    selectionResults.add(timeTaken);

                    //increase size
                    sizeOfArray.add(size);
                    System.out.println(size);
                }
                createCSV(filename);
                writeArrayListToCSV(selectionResults, filename);
                filename = "sizeOfArray";
                createCSV(filename);
                writeSizeToCSV(sizeOfArray, filename);
            } else if (menuStatus == 2) {
                for (int i = size; i < limit; i = i + increment) {
                    //base case
                    int[] numArray = new int[size];
                    populateArrayWithRandom(numArray);
                    int[] quickArray = new int[size];
                    quickArray = numArray;
                    //QuickSort
                    timeBefore = System.nanoTime();
                    quickSort.doSort(quickArray, 0, quickArray.length - 1);
                    timeAfter = System.nanoTime();
                    timeTaken = timeAfter - timeBefore;
                    quickResults.add(timeTaken);
                    //increase size
                    sizeOfArray.add(size);
                    System.out.println(size);
                }
                filename = "quickResults";
                createCSV(filename);
                writeArrayListToCSV(quickResults, filename);
                filename = "sizeOfArray";
                createCSV(filename);
                writeSizeToCSV(sizeOfArray, filename);
            } else if (menuStatus == 3) {
                //loop
                for (int i = size; i < limit; i = i + increment) {
                //base case
                int[] numArray = new int[size];
                populateArrayWithRandom(numArray);
                int[] mergeArray = new int[size];
                mergeArray = numArray;
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
                filename = "mergeResults";
                createCSV(filename);
                writeArrayListToCSV(mergeResults, filename);
                filename = "sizeOfArray";
                createCSV(filename);
                writeSizeToCSV(sizeOfArray, filename);

            } else if (menuStatus == 4) {
                //loop
                for (int i = size; i < limit; i = i + increment) {
                    //base case
                    int[] numArray = new int[size];
                    populateArrayWithRandom(numArray);

                    //duplicates so each sort is on the same data
                    int[] selectionArray = new int[size];
                    selectionArray = numArray;
                    int[] mergeArray = new int[size];
                    mergeArray = numArray;
                    int[] quickArray = new int[size];
                    quickArray = numArray;

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

                    //QuickSort
                    timeBefore = System.nanoTime();
                    quickSort.doSort(quickArray, 0, quickArray.length - 1);
                    timeAfter = System.nanoTime();
                    timeTaken = timeAfter - timeBefore;
                    quickResults.add(timeTaken);

                    //increase size
                    sizeOfArray.add(size);
                    System.out.println(size);
                }
                //stick it in excel
                createCSV(filename);
                writeArrayListToCSV(selectionResults, filename);
                filename = "mergeResults";
                createCSV(filename);
                writeArrayListToCSV(mergeResults, filename);
                filename = "quickResults";
                createCSV(filename);
                writeArrayListToCSV(quickResults, filename);
                filename = "sizeOfArray";
                createCSV(filename);
                writeSizeToCSV(sizeOfArray, filename);
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

