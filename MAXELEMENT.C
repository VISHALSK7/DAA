#include <stdio.h>

int main() {
    int n;

    // Input number of elements in the array
    printf("Enter the number of elements: ");
    scanf("%d", &n);

    int arr[n];

    // Input the elements of the array
    printf("Enter the elements: ");
    for(int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Initialize max to the first element
    int max = arr[0];

    // Loop through the array to find the maximum element
    for(int i = 1; i < n; i++) {
        if(arr[i] > max) {
            max = arr[i];
        }
    }

    // Output the maximum element
    printf("The maximum element is: %d\n", max);

    return 0;
}
