package LeetCodeSolutions;

public class _52_NQueensII {
    public int totalNQueens(int n) {
        int[] state = new int[n];
        return helper(state, 0);
    }

    private int helper(int[] state, int i) {
        int result = 0;
        if (i == state.length) {
            return 1;
        } else {
            for (int j = 0; j < state.length; j++) {
                if (isValid(state, i, j)) {
                    state[i] = j;
                    result += helper(state, i + 1);
                }
            }
        }
        return result;
    }

    private boolean isValid(int[] state, int row, int col) {
        for (int k = 0; k < row; k++) {
            if (state[k] == col || Math.abs(row - k) == Math.abs(col - state[k]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _52_NQueensII solution = new _52_NQueensII();
        System.out.println(solution.totalNQueens(8));
    }
}
