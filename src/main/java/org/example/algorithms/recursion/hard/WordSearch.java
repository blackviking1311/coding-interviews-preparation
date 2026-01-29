package org.example.algorithms.recursion.hard;

public class WordSearch {

    public boolean track(char[][] board, int i, int j, int rows, int cols, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= rows || j >= cols || word.charAt(index) != board[i][j]) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean ans = this.track(board, i + 1, j, rows, cols, word, index + 1) ||
                this.track(board, i - 1, j, rows, cols, word, index + 1) ||
                this.track(board, i, j + 1, rows, cols, word, index + 1) ||
                this.track(board, i, j - 1, rows, cols, word, index + 1);

        board[i][j] = temp;
        return ans;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0 ; i < board.length ; i++) {
            for (int j = 0 ; j < board[i].length ; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(this.track(board, i, j, board.length, board[0].length, word, 0)) return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
