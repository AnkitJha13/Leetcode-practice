class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int j = 0; // to track even numbers

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) { 
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++; // Move the pointer forward for next even number
            }
        }
        return nums; // Return sorted array
    }
}
