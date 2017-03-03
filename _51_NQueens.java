package LeetCodeSolutions;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class _51_NQueens {
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        int[] stack = new int[n];
        helper(stack, 0);
        return result;
    }

    private void helper(int[] stack, int i) {
        if (i == stack.length) {
            List<String> t = new ArrayList<>();
            for (int j = 0; j < stack.length; j++) {
                StringBuilder s = new StringBuilder();
                for (int k = 0; k < i; k++) {
                    if (stack[j] == k)
                        s = s.append('Q');
                    else s = s.append('.');
                }
                t.add(s.toString());
            }
            result.add(t);
        } else {
            for (int j = 0; j < stack.length; j++) {
                stack[i] = j;
                if (isValid(stack, i, j))
                    helper(stack, i + 1);
            }
        }
    }

    private boolean isValid(int[] stack, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (stack[i] == col || abs(row - i) == abs(col - stack[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _51_NQueens solution = new _51_NQueens();
        System.out.println(solution.solveNQueens(8).size());
    }
}
