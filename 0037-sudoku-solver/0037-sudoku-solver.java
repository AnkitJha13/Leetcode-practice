class Solution {
    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') { // Empty cell
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (canPlace(board, row, col, digit)) {
                            board[row][col] = digit; // Place digit
                            if (solve(board)) {
                                return true; // Solution found
                            }
                            board[row][col] = '.'; // Backtrack
                        }
                    }
                    return false; // No valid digit found
                }
            }
        }
        return true; // Board solved
    }

    private boolean canPlace(char[][] board, int row, int col, char digit) {
        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digit) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }

        // Check 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true; // Safe to place the digit
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
