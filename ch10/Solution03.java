public class Solution03 {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */

    public static int search(int[] num, int target) {
        //must check input
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0, end = num.length -1;
         int mid;
         while ( start + 1 < end) {
             mid = end + (start - end) / 2;
             if (num[mid] == target) {
                 return mid;
             }
             
             if (num[mid] > num[start]) {   //start to mid: is in order
                 if ( num[start] <= target && num[mid] >= target ){
                     end = mid;
                 } else {
                     start = mid;
                 }
            } else {   // mid to end: is in order
                 if ( num[mid] <= target && num[end] >= target ){
                     start = mid;
                 } else {
                     end = mid;
                 }
                
            }  
            
         }
         //Find the first index that satisfies
         if (target == num[start]) {
            return start;  
         } else if (target == num[end]) {
             return end;
         }
         return -1;
    }
    
    public static void main(String[] args) {
        int[] a = {8,10,12,16, 22,25, 1, 2, 3, 4, 5 };
        System.out.println(search(a, 10));
        System.out.println(search(a, 16));
        System.out.println(search(a, 17));
        System.out.println(search(a, 5));
    }
}

