class Solution {
    private void getPermutation(int[] nums, List<Integer> ans, List<List<Integer>> result, boolean[] used) {
        // Base case: if the current permutation matches the size of the input array, add it to the result
        if (ans.size() == nums.length) {
            result.add(new ArrayList<>(ans)); // Add a copy of the current permutation
            return;
        }

        // Try each number in the array
        for (int i = 0; i < nums.length; i++) {
            // Skip already used numbers
            if (used[i]) continue;

            // Include the current number in the permutation
            ans.add(nums[i]);
            used[i] = true;

            // Recurse
            getPermutation(nums, ans, result, used);

            // Backtrack
            ans.remove(ans.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getPermutation(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }
}
