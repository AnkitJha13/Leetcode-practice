class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1000000007;
        Stack<Integer> stack = new Stack<>();
        long sumOfMinimums = 0;

        for (int i = 0; i <= arr.length; i++) {
            while (!stack.isEmpty() && (i == arr.length || arr[stack.peek()] >= arr[i])) {
                
                // Get the index of the current minimum
                int mid = stack.pop();
                
                // Find the left boundary index (previous smaller element)
                int leftBoundary;
                if (stack.isEmpty()) {
                    leftBoundary = -1;
                } else {
                    leftBoundary = stack.peek();
                }
                
                // Set the right boundary index (next smaller element or end of array)
                int rightBoundary = i;

                // Calculate how many subarrays include `arr[mid]` as the minimum
                int subarraysLeft = mid - leftBoundary;
                int subarraysRight = rightBoundary - mid;
                long count = (long) subarraysLeft * subarraysRight;
                
                // Calculate the sum from subarrays where `arr[mid]` is the minimum
                long subarraySum = count * arr[mid];
                
                // Update the sum of minimums and apply the modulo to keep within bounds
                sumOfMinimums += subarraySum;
                sumOfMinimums %= MOD;
            }
            // Push the current index to the stack
            stack.push(i);
        }

        // Return the result as an integer
        return (int) sumOfMinimums;
    }
}
