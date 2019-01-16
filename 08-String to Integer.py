'''
@Description: In User Settings Edit
@Author: your name
@Date: 2019-01-15 16:13:35
@LastEditTime: 2019-01-15 17:10:15
@LastEditors: Please set LastEditors
'''
from functools import reduce

class Solution:
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        DIGITS = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9, '-': 0}
        s = list(filter(lambda ch: ch != ' ',list(str)))
        print(s)
        if (s == None or len(s) == 0):
            return 0
        if(s[0] not in DIGITS):
            return 0
        else:
            i = number = 0
            while((i < len(s)) and (s[i] in DIGITS)):
                number = number * 10 + DIGITS[s[i]]
                i += 1
            if (s[0] == '-'):
                return (-1 * number)
            else:
                return number


solution = Solution()
ret = solution.myAtoi('')
print(ret)
            