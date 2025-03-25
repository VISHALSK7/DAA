import java.util.Arrays;

public class SortingAlgorithms {

    // Quick Sort Implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find pivot element such that arr[pivot] is in the correct position
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap arr[i + 1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Merge Sort Implementation
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;

        // Split array into two halves
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        // Copy remaining elements of left (if any)
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        // Copy remaining elements of right (if any)
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {12, 11, 13, 5, 6, 7};
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);  // Copy array for merge sort

        // Quick Sort
        long startTime = System.nanoTime();
        quickSort(arr1, 0, arr1.length - 1);
        long endTime = System.nanoTime();
        long quickSortTime = endTime - startTime;

        System.out.println("Sorted array using Quick Sort: " + Arrays.toString(arr1));
        System.out.println("Quick Sort execution time: " + quickSortTime + " nanoseconds");

        // Merge Sort
        startTime = System.nanoTime();
        mergeSort(arr2);
        endTime = System.nanoTime();
        long mergeSortTime = endTime - startTime;

        System.out.println("Sorted array using Merge Sort: " + Arrays.toString(arr2));
        System.out.println("Merge Sort execution time: " + mergeSortTime + " nanoseconds");
    }
}
