public class Solution05 {
    public static int search(String[] strings, String str, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        /* when mid is empty string , find a closest non-empty string. */
        if (strings[mid].isEmpty()) {   // isEmpty() : judge whether a string is empty or not 
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                //arrive at the edge condition 
                if (left < start && right > end) {
                    return -1;
                } else if (right <= end && !strings[right].isEmpty()) {  //inside "if" still needs to judge the validness of range
                    mid = right;
                    break;
                } else if (left >= start && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }
            
        /* recurse if necessary */
        if (str.equals(strings[mid])) { 
            return mid;
        } else if (strings[mid].compareTo(str) < 0) { 
            // Search in right part
            return search(strings, str, mid + 1, end);
        } else {
            // Search in left part
            return search(strings, str, start, mid - 1);
        }
    }   
        
    public static int search(String[] strings, String str) {
        if (strings == null ) {
            return -1;
        }
        if (str == null || str.isEmpty()) {
            return -1;
        }
        return search(strings, str, 0, strings.length - 1);
    }
    
    public static void main(String[] args) {
        String[] stringList = {"xiaqi", "", "", "anna", "", "", "celia", "","","", "crystal", "", "julie", ""};      
        for (String s : stringList) {
            String cloned = new String(s);
            System.out.println("The string: " + cloned  + " is found at " + search(stringList, cloned));
        }
    }
}
