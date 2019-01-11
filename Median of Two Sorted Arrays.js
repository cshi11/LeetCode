/*
 * @Description: There are two sorted arrays nums1 and nums2 of size m and n respectively.
    Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
    You may assume nums1 and nums2 cannot be both empty.
    Example 1:
    nums1 = [1, 3]
    nums2 = [2]
    The median is 2.0
    Example 2:
    nums1 = [1, 2]
    nums2 = [3, 4]
    The median is (2 + 3)/2 = 2.5
 */
// 太他妈难了，看解释吧  https://leetcode.com/problems/median-of-two-sorted-arrays/solution/
// 核心 所谓中间数，就是用一个数把一堆数分成两堆，每一堆一样多的那个数。
// 用 i 和 j 分别区分两个数组 A 和 B ，保证 左边的堆 等于 右边的堆，因此 j = (m+n+1)/2 - i   (让 m < = n 保证 j 不为负数)
// 接下来 保证 B[j−1]≤A[i] and A[i−1]≤B[j]
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    // 保证 nums1 是短的那个
    if (nums1.length > nums2.length) {
        var nums = nums1
        nums1 = nums2
        nums2 = nums
    }
    let m = nums1.length
    n = nums2.length
    i_min = 0
    i_max = m
    i = j = 0

    while (i_max >= i_min) {
        i = parseInt(i_min + i_max / 2)
        j = parseInt((m + n + 1) / 2 - i)
        if (i > i_min && nums1[i - 1] > nums2[j]) {
            // i 左移
            i_max--
        } else if (i < i_max && nums2[j - 1] > nums1[i]) {
            // i 右移
            i_min++
        } else {
            let max_left = 0
            if (i === 0) {
                max_left = nums2[j - 1]
            } else if (j == 0) {
                max_left = nums1[i - 1]
            } else {
                max_left = (nums1[i - 1] > nums2[j - 1]) ? nums1[i - 1] : nums2[j - 1]
            }
            if ((m + n) % 2 === 1) {
                return max_left
            }

            let min_right = 0
            if (i === m) {
                min_right = nums2[j]
            } else if (j === n) {
                min_right = nums1[i]
            } else {
                min_right = (nums1[i] > nums2[j]) ? nums2[j] : nums1[i]
            }

            return (min_right + max_left) / 2
        }
    }
    };

var nums1 = []
    nums2 = [2, 3]

var ret = findMedianSortedArrays(nums1, nums2)

console.log(ret)