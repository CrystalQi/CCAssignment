import java.util.*;
public class Solution07 {
  public static void rotateMatrix(int[][] matrix) {
    int n = matrix.length;
    //Handle in a layer-by-layer manner
    for (int layer = 0; layer < n / 2; layer++) {
      // first, last: records the starting and ending place in each operation
      int first = layer;
      int last = n - 1 - layer;
      for (int i = first; i < last; i++) {
        int offset = i - first;
        int offset_last = last-offset;
        int top = matrix[first][i];
        
        // first tranport left to top
        matrix[first][i] = matrix[offset_last][first];

        // bottom -> left
        matrix[offset_last][first] = matrix[last][offset_last];

        // right -> bottom
        matrix[last][offset_last] = matrix[i][last];

        // top -> right
        matrix[i][last] = top;
      }
    }
  }
  public static void main(String[] args) {
    int[][] matrix = new int[][]{
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20},
        {21, 22, 23, 24, 25}
    };
    rotateMatrix(matrix);
    for (int[] a : matrix)
        System.out.println(Arrays.toString(a));
  }
}
