class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2; // To compare last element with something, we must start from second last index (n-2).
        
        // Step 1: Find the first index i where arr[i] < arr[i+1] (from right)
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        
        // Step 2: If such index found, find just larger element to swap
        if (i >= 0) {
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }
        
        // Step 3: Reverse the part after i to get next smallest lexicographical order
        reverse(arr, i + 1, n - 1);
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
