public class QuickSort extends SortingAlgorithm{
    public QuickSort () {
        super();
    }
    public void doSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition index
            int pi = partition(array, low, high);

            // Recursively sort elements before and after partition
            doSort(array, low, pi - 1);
            doSort(array, pi + 1, high);
        }
    }

    // Helper method to partition the array
    private static int partition(int[] array, int low, int high) {
        // Choose the pivot element (here we take the last element)
        int pivot = array[high];
        int i = (low - 1); // Index of smaller element

        // Loop through the array and partition
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                i++;
                // Swap elements at i and j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap the pivot element with the element at i + 1
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Return the partition index
    }

}
