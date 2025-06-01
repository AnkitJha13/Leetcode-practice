class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int product1 = nums[n-1] * nums[n-2] * nums[n-3]; // top 3 largest
        int product2 = nums[0] * nums[1] * nums[n-1];  // 2 smallest * largest

        return Math.max(product1, product2);
    }
}