public class Test {
  static int[] fall_squares(int[][] positions) {
    int n = positions.length;
    int[] ans = new int[n];
    int[] arr = new int[n];
    int maxheight = 0;// 最大高度
    for (int i = 0; i < n; i++) {
      int height = 0;
// 对比之前落下的有没有重叠
      for (int j = i - 1; j >= 0; j--) {
// 记录位置
        int x = positions[i][0];
        int x_length = positions[i][0] + positions[i][1] - 1;
// 记录对比的位置
        int y = positions[j][0];
        int y_length = positions[j][0] + positions[j][1] - 1;
// 判断重叠，三种情况，左端压着，右端压着，直接覆盖大于
        if (x >= y && x <= y_length || x_length >= y && x_length <= y_length || x < y && x_length > y_length) {
          height = Math.max(height, arr[j]);
        }
      }
      // 写一个注释
      /*
      * 这样很好
      * */
// 记录每个方块落下位置
      arr[i] = height + positions[i][1];
// 取当前最大高度，存入ans返回
      maxheight = Math.max(maxheight, arr[i]);
      ans[i] = maxheight;
    }
    return ans;
  }
  
  public static void main(String[] args) {
    int[][] positions = {{1, 2}, {2, 3}, {6, 1}};
    int[] ans = fall_squares(positions);
    
    for (int i = 0; i < ans.length; i++) {
      System.out.print(ans[i] + ",");
    }
  }
}