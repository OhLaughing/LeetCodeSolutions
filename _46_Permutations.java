package LeetCodeSolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gustaov on 2017/2/26.
 */
public class _46_Permutations {
    List<List<Integer>> result;
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        visited = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        permuteDFS(nums, temp);
        return result;
    }

    private void permuteDFS(int[] nums, List<Integer> temp) {
        if (temp.size() == nums.length) {
            List<Integer> l = new ArrayList<>(temp);
            result.add(l);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(visited[i])
                    continue;
                visited[i] = true;
                temp.add(nums[i]);
                permuteDFS(nums,temp);
                visited[i]= false;
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[]a = {1,2,3};
        _46_Permutations solution = new _46_Permutations();
        System.out.println(solution.permute(a));
    }
}
