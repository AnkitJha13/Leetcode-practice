class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Create sets to store unique elements from both arrays
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        // Add elements of nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }
        
        // Add elements of nums2 to set2
        for (int num : nums2) {
            set2.add(num);
        }
        
        // Create a set to store the intersection results
        Set<Integer> intersection = new HashSet<>();
        
        // Traverse set1 and check if elements are in set2
        for (int num : set1) {
            if (set2.contains(num)) {
                intersection.add(num);
            }
        }

        // // Convert the result set to an array
        int[] result = new int[intersection.size()];
        int i = 0;
        for (int num : intersection) {
            result[i] = num;
            i++;
        }
        
        return result;

        
    }
}
