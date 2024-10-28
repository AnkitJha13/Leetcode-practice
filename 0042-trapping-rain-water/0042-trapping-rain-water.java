class Solution {
    public int trap(int[] height) {
        int left = 0;  // Initialize left pointer at the start of the array
        int right = height.length - 1;  // Initialize right pointer at the end of the array
        int leftMax = height[left];  // Maximum height on the left side
        int rightMax = height[right];  // Maximum height on the right side
        int twater = 0;  // Initialize total water trapped to 0

        while (left < right) {  // Continue until the two pointers meet
            if (leftMax < rightMax) {  // If left max is less than right max
                left++;  // Move the left pointer to the right
                leftMax = Math.max(leftMax, height[left]);  // Update left max
                twater += leftMax - height[left];  // Calculate trapped water
            } else {  // If right max is less than or equal to left max
                right--;  // Move the right pointer to the left
                rightMax = Math.max(rightMax, height[right]);  // Update right max
                twater += rightMax - height[right];  // Calculate trapped water
            }
        }

        return twater;  // Return the total trapped water
    }
}
