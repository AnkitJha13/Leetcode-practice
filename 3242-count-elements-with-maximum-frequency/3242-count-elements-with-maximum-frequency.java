class Solution {
    public int maxFrequencyElements(int[] nums) {

        // count frequencies of all elements
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // find max frequency value
        int maxFreq = 0;
        for(int f : freq.values()){
            maxFreq = Math.max(maxFreq, f);
        }

        // count total no of elements having that frequency
        int total = 0;
        for(int f : freq.values()){
            if(f == maxFreq){
                total += f;
            }
        }

        return total;
    }
}