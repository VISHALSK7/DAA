#include <stdio.h>

// Function to perform binary search
int binarySearch(int arr[], int n, int target) {
    int left = 0;
    int right = n - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;  // To avoid overflow

        // Check if the target is present at mid
        if (arr[mid] == target) {
            return mid;  // Target found, return its index
        }

        // If the target is smaller, ignore the right half
        if (arr[mid] > target) {
            right = mid - 1;
        }
        // If the target is larger, ignore the left half
        else {
            left = mid + 1;
        }
    }

    return -1;  // Target not found
}

int main() {
    int n, target;

    // Input the number of elements in the array
    printf("Enter the number of elements: ");
    scanf("%d", &n);

    int arr[n];

    // Input the sorted array elements
    printf("Enter the sorted elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Input the target element to search for
    printf("Enter the element to search for: ");
    scanf("%d", &target);

    // Perform binary search
    int result = binarySearch(arr, n, target);

    // Output the result
    if (result != -1) {
        printf("Element found at index %d\n", result);
    } else {
        printf("Element not found in the array.\n");
    }

    return 0;
}
