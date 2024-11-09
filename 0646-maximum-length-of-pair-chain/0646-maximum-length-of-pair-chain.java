class Solution {
    public int findLongestChain(int[][] pairs) {
        

        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int maxLength = 1;
        int currentEnd = pairs[0][1];

        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0] > currentEnd){
                maxLength++;
                currentEnd = pairs[i][1];
            }
        }

        return maxLength;
    }
}