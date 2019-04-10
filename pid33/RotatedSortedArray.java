package pid33;
/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
 */
public class RotatedSortedArray{

    private static int findIndex(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int index = helper(arr, start, end, target);
        return index;
    }

    private static int helper(int[] arr, int start, int end, int target){
        int mid = (end - start)/2 + start;
        if(start > end || start < 0 || end >= arr.length)    return -1;
        if(arr[start] == target)    return start;
        if(arr[mid] == target)    return mid;
        if(arr[end] == target)    return end;
        
        if(arr[mid] > arr[start]){  // start 到 mid 是递增的
            if(arr[start] < target && target < arr[mid])  
                return helper(arr, start, mid - 1, target);
            else
                return helper(arr, mid + 1, end, target);
        }else{  // mid 到 end 是递增的
            if(arr[mid] < target && target < arr[end])  
                return helper(arr, mid + 1, end, target);
            else
                return helper(arr, start, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        int[] rotatedArray = {1, 3};
        int target = 0;
        System.out.println(findIndex(rotatedArray, target));
    }
}