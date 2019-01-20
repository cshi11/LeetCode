'''
@Description: In User Settings Edit
@Author: your name
@Date: 2019-01-20 14:09:24
@LastEditTime: 2019-01-20 15:20:25
@Note: 3 Sum 升级版。。。
'''
class Solution:
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums.sort()
        print (nums)
        ret = set()
        if len(nums) < 4:
            return []
        for i, v1 in enumerate(nums[:len(nums)-3]):
            for j, v2 in enumerate(nums[i+1: len(nums) - 2], i + 1):
                d = {}
                for v3 in nums[j + 1:]:
                    if d.get(target - v1 - v2 - v3, 0):
                        fo = [v1, v2, v3, target-v1-v2-v3]
                        fo.sort()
                        ret.add(tuple(fo))
                    else:
                        d[v3] = 1
        return list(map(list,ret))

solution = Solution()
ret = solution.fourSum([1, 0, 3, 2], 0)
print(ret)