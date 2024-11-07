class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Base case: Add the current subset when we've processed all elements
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Exclude the current element and move to the next
        generateSubsets(index + 1, nums, current, result);

        // Include the current element and move to the next
        current.add(nums[index]);
        generateSubsets(index + 1, nums, current, result);

        // Backtrack to remove the last added element
        current.remove(current.size() - 1);
    }
}
