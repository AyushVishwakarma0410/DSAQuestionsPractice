package QuickSelectAlgorithm;

public class QuickSelect {

    public static int findKthSmallest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int targetIndex = k - 1; // 1st smallest = index 0

        while (left <= right) {
            // 1. Partition the array and get the pivot's final index
            int pivotIndex = partition(nums, left, right);

            // 2. Check if we found the answer
            if (pivotIndex == targetIndex) {
                return nums[pivotIndex];
            }

            // 3. Cut the search space in half
            if (pivotIndex < targetIndex) {
                left = pivotIndex + 1; // Look Right
            } else {
                right = pivotIndex - 1; // Look Left
            }
        }
        return -1;
    }

    // Standard Lomuto Partition Scheme
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // Choose last element as pivot
        int storeIndex = left;  // Pointer for where the next smaller element goes

        for (int i = left; i < right; i++) {
            // If element is smaller than pivot, swap it to the left
            if (arr[i] < pivot) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }

        // Move pivot to its correct final position
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,5,4,6,2};
        int k = 3; // Find 3rd smallest
        System.out.println("3rd Smallest: " + findKthSmallest(arr, k));
        // Output should be 7 (Sorted: 3, 4, 7, 10, 15, 20)
    }
}
