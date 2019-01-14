'''
@Description: Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers 
within the 32-bit signed integer range: [−231,  231 − 1]. 
For the purpose of this problem, 
assume that your function returns 0 when the reversed integer overflows.

@Author: cshi
@Date: 2019-01-14 10:01:37
@LastEditTime: 2019-01-14 10:36:05
@LastEditors: your name
'''

class Solution:
    # 主题思想其实是一个 pop 和 push 的过程——反转类题目都是
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        x_abs = abs(x)
        x_re = 0
        while x_abs > 0:
            x_re = (x_abs % 10) + x_re * 10
            x_abs = x_abs // 10
        
        if x_re > 2**31:
            return 0
        elif x > 0:
            return x_re
        else:
            return x_re * -1


soulution = Solution()
y = soulution.reverse(1534236469)
print(y)