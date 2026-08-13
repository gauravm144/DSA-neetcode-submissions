class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (bt(board, word, 0, i, j))
                        return true;
                }
            }
        }
        return false;
    }
    boolean bt(char[][] board, String word, int k, int i, int j) {
        if (word.length() == k)
            return true;
        if (i < 0 || i == board.length || j < 0 || j == board[0].length)
            return false;

        if (board[i][j] == '@')
            return false;

        if (board[i][j] == word.charAt(k)) {
            board[i][j] = '@';
            // left
            boolean left = bt(board, word, k + 1, i, j - 1);
            // up
            boolean up = bt(board, word, k + 1, i - 1, j);
            // right
            boolean right = bt(board, word, k + 1, i, j + 1);
            // down
            boolean down = bt(board, word, k + 1, i + 1, j);

            board[i][j] = word.charAt(k);
            return left || up || right || down;
        } else
            return false;
    }
}
