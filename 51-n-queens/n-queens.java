import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        nQueens(board, 0, n, ans);
        return ans;
    }

    private static void nQueens(char[][] board, int currentRow, int n, List<List<String>> ans) {
        if (currentRow == n) {
            ans.add(constructAns(board, n));
            return;
        }

        for (int currentCol = 0; currentCol < n; currentCol++) {
            if (isValid(board, currentRow, currentCol, n)) {
                board[currentRow][currentCol] = 'Q';
                nQueens(board, currentRow + 1, n, ans);
                board[currentRow][currentCol] = '.'; // Backtrack
            }
        }
    }

    private static List<String> constructAns(char[][] board, int n) {
        List<String> current = new ArrayList<>();
        for (char[] row : board) {
            current.add(new String(row));
        }
        return current;
    }

    private static boolean isValid(char[][] board, int currentRow, int currentCol, int n) {
        return isColValid(board, currentCol, currentRow) && isDiagonalValid(board, currentRow, currentCol, n);
    }

    private static boolean isColValid(char[][] board, int currentCol, int currentRow) {
        for (int row = 0; row < currentRow; row++) { // Only check rows above
            if (board[row][currentCol] == 'Q')
                return false;
        }
        return true;
    }

    private static boolean isDiagonalValid(char[][] board, int currentRow, int currentCol, int n) {
        int x, y;

        // Left Up Diagonal
        x = currentRow;
        y = currentCol;
        while (x >= 0 && y >= 0) {
            if (board[x][y] == 'Q') return false;
            x--;
            y--;
        }

        // Right Up Diagonal
        x = currentRow;
        y = currentCol;
        while (x >= 0 && y < n) { // Fix condition from y <= n to y < n
            if (board[x][y] == 'Q') return false;
            x--;
            y++;
        }
        return true;
    }
}
