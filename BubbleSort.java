public class BubbleSort extends SortingAlgorithm{
    public BubbleSort(){
        super();
    }

    public void doSort(int[] data) {
        boolean swapped = true;
        for (int out = data.length-1; out > 0; out--) {
            swapped = false;
            for (int in = 0; in < out; in++) {
                if (data[in] > data[in + 1]) {
                    swapped = true;
                    int tmp = data[in];        // swap items
                    data[in] = data[in + 1];    //
                    data[in + 1] = tmp;        //
                }
            }
            if (swapped == false)
                out = 0;
        }
    }
}
