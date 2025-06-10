class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = m-1;

        while(row < n && col >= 0){
            int element = matrix[row][col];

            if(element == target){
                return true;
            }
            else if(element < target){
                row++;
            }
            else{
                col--;
            }
        }

        return false;
    }
}