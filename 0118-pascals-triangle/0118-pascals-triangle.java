class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ansRow = new ArrayList<>();
        
        
        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1); // The first element of each row is always 1
            
            // to find middle elements 
            for (int col = 1; col < row; col++) {
                int value = ansRow.get(row - 1).get(col - 1) + ansRow.get(row - 1).get(col);
                currentRow.add(value);
            }
            
            // Add the last element of each row, which is always 1
            if (row > 0) {
                currentRow.add(1);
            }
            
           
            ansRow.add(currentRow);
        }
        
        return ansRow;
    }
}
