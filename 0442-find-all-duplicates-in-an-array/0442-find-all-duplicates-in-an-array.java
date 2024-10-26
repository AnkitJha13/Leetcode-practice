class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                duplicates.add(num);
            }
            else{
                set.add(num);
            }
        }

        return duplicates;
    }
}