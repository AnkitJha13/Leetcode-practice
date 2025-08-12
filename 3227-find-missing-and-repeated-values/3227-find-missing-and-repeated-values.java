class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int total = n * n;

        int freq[] = new int[total+1];  // we do total + 1 so that freq of 0 is also counted

        // outer loop over grid and inner loop over values
        for(int row[] : grid){
            for(int val : row){
                freq[val]++;
            }
        }

        int repeating = -1, missing = -1;
        for(int i=1;i<=total;i++){
            if(freq[i] == 2) repeating = i;
            else if(freq[i] == 0) missing = i;
        }

        return new int[]{repeating, missing};
    }
}