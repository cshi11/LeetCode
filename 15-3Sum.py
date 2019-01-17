'''
@Description: 
Given an array nums of n integers,
 are there elements a, b, c in nums such that a + b + c = 0? 
 Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
@Author: your name
@Date: 2019-01-17 14:49:57
@LastEditTime: 2019-01-17 14:50:55
@LastEditors: your name
@Note: 关键在于时间复杂度。怎样由 O(n^3) 降到 O(n^2). 此处应用了字典。
        对于每一个 v:
        把其他每一个 k 值的 (-v-k) 值算好，存入字典的键值中。然后如果之后的某个 k 值等于某个键值。
        就将 v , k, -v-k 放入结果
'''

class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ret = set()
        nums.sort()
        for i, v in enumerate(nums):
          if (i > 1 and v == nums[i - 1]):
            continue
          d = {}
          for k in nums[i+1:] :
            if (k not in d):
              d[- v - k] = 1
            else:
              ret.add((v, k, -v - k))
        return list(map(list, ret))

solution = Solution()
ret = solution.threeSum([4,-10,-11,-12,-8,-12,-14,-11,-6,2,-4,2,3,12,-3,-12,-14,-12,-8,-9,-6,-3,10,2,14,10,7,-7,-9,0,-9,10,-2,-5,14,5,-9,7,9,0,-14,12,10,4,9,-8,8,11,-5,-15,-13,-3,-11,4,14,11,-1,-2,-11,5,14,-4,-8,-3,6,-9,9,12,6,3,-10,7,0,-15,-3,-13,-8,12,13,-5,12,-15,7,8,-4,-2,4,2,3,9,-8,2,-10,-1,6,3,-2,0,-7,11,-12,-2,3,-4,-2,7,-2,-3,4,-12,-1,1,10,13,-5,-9,-12,6,8,7,0,7,-6,5,13,8,-14,-12])
print (ret)

