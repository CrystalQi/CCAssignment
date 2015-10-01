public class Solution09 {
  public static class Element {
    public int row;
    public int col;
    public Element(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  public static Element findElement(int[][] matrix, int element) {
    int row = 0;
    int col = matrix[0].length - 1;
    //start from right-top element 
    while (row < matrix.length && col >= 0) {
      if (matrix[row][col] == element)
        return new Element(row, col);
      else if (matrix[row][col] > element)
        col--;
      else
        row++;
    }
    //already hit the edge, so not found, return null
    return null;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{
        {1,2,3,4},
        {5,6,8,9},
        {7,10,15,20}
    };
    Element e1 = findElement(matrix, 12);
    if (e1  != null) {
      System.out.println("12 is located at row: " + e1.row + " - col: " + e1.col);
    }
    else {
      System.out.println("12 is not found");
    }
      
    Element e2 = findElement(matrix, 7);
    if (e2  != null) {
      System.out.println("7 is located at" +"(" + e2.row + " , " + e2.col+ ")");
    }
    else {
      System.out.println("7 is not found");
    }
  }
}
