'''
@Description: In User Settings Edit
@Author: your name
@Date: 2019-01-18 10:21:36
@LastEditTime: 2019-01-18 21:56:30
@LastEditors: Please set LastEditors
@Note: O(n^3) 第一想法是根据输入长度决定循环深度，但无法实现，而且复杂度太大。
        利用栈堆的原理。
'''
from functools import reduce
class Solution:
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        DIGIT = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        # if digits is "":
        #     return []
        # ret1 = list(DIGIT[digits[0]])
        # ret2 = []
        # length = len(digits)
        # for i in range(1, length):
        #     for s in ret1:
        #         for ch in DIGIT[digits[i]]:
        #             ret2.append(s + ch)
        #     ret1 = ret2
        #     ret2 = []
        # return ret1
        """
         一行代码版本
        reduce(function, sequence, initial) 
        initial 如果设置，将会被置于 sequence 队列的头部。并且当 sequence 为空时作为默认值
        acc 为现在拼好的词序列，digit 为这一轮要处理的数字
        """
        return reduce(lambda acc, digit: [x + y for x in acc for y in DIGIT[digit]], digits, [''])
                    



solution = Solution()
ret = solution.letterCombinations("234")
print (ret)
