class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;  // return the first duplicate found
            }
        }
        return -1; 
    }
}