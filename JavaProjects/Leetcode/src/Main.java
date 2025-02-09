import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> answer = new ArrayList<>();
        int rows_end = grid.length;
        int cols_end = grid[0].length;

        for(int i = 0; i < grid.length; i++){
            for (int j = (i % 2 == 0 ? 0 : cols_end - 1); (i % 2 == 0 ? j < grid[i].length : j >= 0); (i % 2 == 0 ? (j += 2) : (j -= 2))){
                answer.add(grid[i][j]);
            }
        }
        return answer;
    }
}