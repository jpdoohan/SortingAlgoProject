import java.text.DecimalFormat;



public class SelectionSort extends SortingAlgorithm {
    public SelectionSort() {
        super();
    }

    public void doSort(int data[]) {
        int in, out, min;
        for (out = 0; out < data.length - 1; out++) {
            min = out;
            for (in = out + 1; in < data.length; in++) {
                if (data[in] < data[min]) {
                    min = in; // new minimum
                }
            }
            int tmp = data[out]; // swap items
            data[out] = data[min]; //
            data[min] = tmp; //
        }
    }
}
