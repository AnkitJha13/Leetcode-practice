class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0;i<n;i++){
            sum1 += mat[i][i];

            if(i != n-1-i){
                sum2 += mat[i][n-1-i];
            }
        }

        return sum1 + sum2;
    }
}