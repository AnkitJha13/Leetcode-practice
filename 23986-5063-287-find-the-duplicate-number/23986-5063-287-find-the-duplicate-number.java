class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        // Phase 1: Detect the cycle
        while (slow != fast || slow == 0) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // Phase 2: Find the duplicate number
        int slow2 = 0;
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }
}
