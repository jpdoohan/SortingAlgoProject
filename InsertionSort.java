public class InsertionSort extends SortingAlgorithm{
    public InsertionSort() {
        //default
    }

    public void doSort(int [] pNumArray) {
        int in = 0;
        int out = 0;
        int temp = 0;
        for (out = 1; out < pNumArray.length; out++) {
            temp = pNumArray[out]; //pick current element to insert
            for (in = out; in > 0 && pNumArray[in-1] >= temp; in--) {
                //loop through the array when in is more than 0 and
                pNumArray[in] = pNumArray[in-1];//shift elements to right
            }
            pNumArray[in] = temp; //insert the element in the right place
        }
    }


}
