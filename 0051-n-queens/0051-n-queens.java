
class Solution {
    private void solveQueens(List<List<String>> solutions, char[][] board, int row, int n) {
        if (row == n) {
            solutions.add(convertBoardToList(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (canPlaceQueen(board, row, col, n)) {
                board[row][col] = 'Q'; // Place queen
                solveQueens(solutions, board, row + 1, n); // Recurse for next row
                board[row][col] = '.'; // Backtrack
            }
        }
    }
    
    private boolean canPlaceQueen(char[][] board, int row, int col, int n) {
        // Check vertical up
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        
        // Check diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        // Check diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
    }
    
    private List<String> convertBoardToList(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        solveQueens(solutions, board, 0, n);
        return solutions;
    }
}
