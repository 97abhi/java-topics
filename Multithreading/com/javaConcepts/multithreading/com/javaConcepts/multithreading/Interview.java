/*
 * Program to sort array such that it has maximium then minimum, then next maximum, then next minimum, for e.g 
a[] = {1,4,10,15,2,45} 
finalArray[] = {45,1, 15, 2, 10, 4} 

1. sort the array 
2. use 2 pointers to rearrange the 
 */

import java.util.Arrays;

public class Interview{
    public static void main(String[] args) {

        int[] arr = {1,4,10,15,2,45}; // 1 2 4 10 15 45 -- 1 45 15  10 14 2 --> 1 
        sort(arr);
        
    }

    private static void sort(int[] arr) {
       Arrays.sort(arr);
       
       int left = 0, right = arr.length-1;
        int [] res =  new int[arr.length];
       int index = 0;
       while (left < right) {
        res[index] = arr[right];
        res[++index] = arr[left];
        left++;
        right--;
        index++;
       }

       for(int i : res){
        System.out.println(i);
       }
    }
}