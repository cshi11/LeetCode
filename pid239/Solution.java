package pid239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Sliding Window Maximum Given an array nums, there is a sliding window of size
 * k which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position. Return the max sliding window. Example:
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3 Output: [3,3,5,5,6,7]
 * Explanation:
 * 
 * Window position Max --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3 -1 -3] 5
 * 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3 6] 7 6 1 3
 * -1 -3 5 [3 6 7] 7
 */

class Solution {
    /**
     * 普通版本，O(k * n)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)    return new int[0];

        int[] res = new int[nums.length - k + 1];
        for(int i = k - 1, j = 0; i < nums.length; ++i){
            res[j ++] = maxOf(nums, i - k + 1, i);
        }
        return res;
    }

    private int maxOf(int[] nums, int start, int end){
        int max = nums[start];
        for(int i = start + 1; i <= end; ++i){
            if(nums[i] > max)   max = nums[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums1 = {};
        int[] res = new Solution().maxSlidingWindow_1(nums, 3);
        int[] res1 = new Solution().maxSlidingWindow(nums1, 1);

        for(int i : res){
            System.out.println(i);
        }
    }

/**
 * 利用双向对列的版本，O(n)
 * @param a
 * @param k
 * @return
 */
    public int[] maxSlidingWindow_1(int[] a, int k) {		
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}
}