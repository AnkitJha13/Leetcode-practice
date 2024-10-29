class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> st = new Stack<>();
        long sumOfMinimums = 0;
        long sumOfMaximums = 0;

        // sum of minimums for all subarrays
        for (int i = 0; i <= nums.length; i++) {
            while (!st.isEmpty() && (i == nums.length || nums[st.peek()] >= nums[i])) {
                int mid = st.pop();
                int leftBoundary = st.isEmpty() ? -1 : st.peek();
                int rightBoundary = i;
                long subarraysLeft = mid - leftBoundary;
                long subarraysRight = rightBoundary - mid;
                long count = subarraysLeft * subarraysRight;
                long subarraySum = count * nums[mid];
                sumOfMinimums += subarraySum;
            }
            st.push(i);
        }

        // Reset the stack
        st.clear();

        // sum of maximums for all subarrays
        for (int i = 0; i <= nums.length; i++) {
            while (!st.isEmpty() && (i == nums.length || nums[st.peek()] <= nums[i])) {
                int mid = st.pop();
                int leftBoundary = st.isEmpty() ? -1 : st.peek();
                int rightBoundary = i;
                long subarraysLeft = mid - leftBoundary;
                long subarraysRight = rightBoundary - mid;
                long count = subarraysLeft * subarraysRight;
                long subarraySum = count * nums[mid];
                sumOfMaximums += subarraySum;
            }
            st.push(i);
        }

        //  difference 
        return sumOfMaximums - sumOfMinimums;
    }
}
