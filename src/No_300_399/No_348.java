package No_300_399;
// No.348.Design Tic-Tac-Toe
// https://leetcode.com/problems/design-tic-tac-toe
public class No_348 {
    class TicTacToe {
        int[] rows;
        int[] cols;
        int size;
        int diag;
        int antiDiag;

        public TicTacToe(int n) {
            this.rows = new int[n];
            this.cols = new int[n];
            this.size = n;
        }

        public int move(int row, int col, int player){
            int sign = player == 1 ? 1 : -1;
            rows[row] += sign;
            cols[col] += sign;
            if (row == col) diag += sign;
            if (row + col == size - 1) antiDiag += sign;
            if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size ||
            Math.abs(diag) == size || Math.abs(antiDiag) == size) return player;
            return 0;
        }

    }
}
