'''
@Description: Given an array nums of n integers and an integer target,
 find three integers in nums such that the sum is closest to target. 
 Return the sum of the three integers.
 You may assume that each input would have exactly one solution.

 Example:

Given array nums = [-1, 2, 1, -4], and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

@Author: your name
@Date: 2019-01-17 22:01:43
@LastEditTime: 2019-01-17 22:45:09
@LastEditors: your name
@Note: O(n^2) 算法。
        固定住一个 i，剩余两个从两侧走向中间
        [-1,1,2,4,5,6]
         i  j->    <-k
'''
class Solution:
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        ret = nums[0] + nums[1] + nums[2]
        if ret > target:
            return ret
        for i in range(len(nums) - 2):
            j = i + 1
            k = len(nums) - 1
            while j < k:
                sum = nums[i] + nums[j] + nums[k]
                if sum == target:
                    return sum
                if abs(sum - target) < abs(ret - target):
                    ret = sum
                if sum > target:
                    k -= 1
                else:
                    j += 1
        return ret


solution = Solution()
ret = solution.threeSumClosest([-1,2,1,-4], 1)
print (ret)