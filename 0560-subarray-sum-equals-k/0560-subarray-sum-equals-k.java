class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(mpp.containsKey(sum-k)){
                count += mpp.get(sum-k);
            }

            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}