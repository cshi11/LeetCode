'''
@Description: 
Given n non-negative integers a1, a2, ..., an ,
 where each represents a point at coordinate (i, ai). 
 n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 Find two lines, which together with x-axis forms a container,
such that the container contains the most water.
Note: You may not slant the container and n is at least 2.
@Author: your name
@Date: 2019-01-16 13:33:55
@LastEditTime: 2019-01-16 13:54:31
@LastEditors: Please set LastEditors
'''
# i j 两个指针指向list两端。逐个向中心靠拢。可以将 O(n^2) 降到 O(n)
class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        max_V = 0
        i = 0
        j = len(height) - 1
        if height is None:
            return 0
        while(i < j):
            V = min(height[i], height[j]) * (j - i)
            if(V > max_V):
                max_V = V
            if height[i] > height[j]:
                j -= 1
            else:
                i += 1
        return max_V

solution = Solution()
ret = solution.maxArea([1,8,6,2,5,4,8,3,7])
print(ret)