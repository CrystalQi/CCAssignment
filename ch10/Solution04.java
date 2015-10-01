public class Solution04 {
    public static int binarySearch(Listy list, int value, int left, int right) {
        int mid;
        while (left <= right) {
            mid = right +  (left - right) / 2;
            int middle = list.elementAt(mid);
            //left corresponds to index/2, which must be less than the right bound of original array
            //but right can exceed, so middle might also be out of bounds 
            if (middle > value || middle == -1) {
                right = mid - 1;
            } else if (middle < value) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;      
    }
    // search in Listy list for value 
    public static int search(Listy list, int value) {
        int index = 1;
        //do  not have size information, so each time self-increment index by two times 
        //as the list is sorted , we can break out of the loop when currValue > value
        while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
            index *= 2;
        } // find an interval [index/2, index] where value must be in 
        return binarySearch(list, value, index / 2, index);
    }
    
    public static void main(String[] args) {
        int[] array = {1,2,3,4,8,9,10,15,17,37,76};
        Listy list = new Listy(array);
        for (int a : array) {
            System.out.println("element "+ a + " appears at index " + search(list, a));
        }
        System.out.println("element 100 " + " appears at index " + search(list, 100));
    }
}



 class Listy {
    int[] array;
    public Listy(int[] arr) {
        array = arr.clone();
    }
    public int elementAt(int index) {
        if (index >= array.length) {
            return -1;
        }
        return array[index];
    }
}
