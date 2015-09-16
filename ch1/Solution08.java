import java.util.*;
import java.io.*;

public class Solution08 {
  public static void setZeroes(int[][] matrix) {
  //Achieve the O(1) method
        if(matrix == null || matrix.length == 0)
            return;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // use two varialbles to record row0, col0
        boolean empty_row0 = false;
        boolean empty_col0 = false;
        for(int i = 0; i < cols; i++){
            if(matrix[0][i] == 0){
                empty_row0 = true;
                break;
            }
        }
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == 0){
                empty_col0 = true;
                break;
            }
        }

        //Set flags for other rows and columns 
        for(int i = 1; i < rows; i++) {
            for(int j =1; j<cols; j++){
                if(matrix[i][j] == 0){   
                    matrix[0][j] = 0; 
                    matrix[i][0] = 0;
                }
            }
        }
        
        //Set rows, columns to zero according to flags
        for(int i = 1; i<rows; i++) {
            for (int j=1; j< cols; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) 
                    matrix[i][j] = 0;
            }
        }
      
        if(empty_row0){
            for(int i = 0; i < cols; i++){
                matrix[0][i] = 0;
            }           
        }
    
        if(empty_col0){
            for(int i = 0; i < rows; i++){
                matrix[i][0] = 0;
            }           
        }

    }

    public static void main(String[] args) {
    int[][] matrix = new int[][]{
      {0, 1, 1, 1, 0},
      {1, 0, 1, 0, 1},
      {1, 1, 1, 1, 1},
      {0, 0, 1, 0, 1},
      {1, 1, 1, 0, 0}
    };
    for (int i = 0; i < matrix.length; i++)
         System.out.println(Arrays.toString(matrix[i]));
    
    setZeroes(matrix);
    System.out.println();
    System.out.println("After setZeroes: ");
    
    for (int i = 0; i < matrix.length; i++) 
         System.out.println(Arrays.toString(matrix[i]));
  }
}
