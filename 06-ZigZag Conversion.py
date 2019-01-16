'''
@Description: The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
@Author: cshi
@Date: 2019-01-13 11:32:11
@LastEditTime: 2019-01-13 11:33:20
@LastEditors: your name
'''


class Solution:
    # 垃圾代码
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """

        delta = [0]
        zigzag = list()
        def f(i):
            if numRows == 1:
                delta[0] =1
            elif(i == 0 or i == numRows - 1):
                delta[0] = 2 * (numRows - 1)
            elif(delta[0] == 0):
                delta[0] = (2*numRows-2*i-2)
            elif( delta[0] == (2*numRows-2*i-2)):
                delta[0] = 2*i
            else:
                delta[0] = (2*numRows-2*i-2)
            return delta[0]

        if (s):
            for i in range(numRows):
                delta[0] = 0
                j = i
                ziglist = list()
                while(j < len(s)):
                    ziglist.append(s[j])
                    j = j + f(i)
                print(ziglist)
                zigzag = zigzag + ziglist
        return "".join(zigzag)
    # 大神代码  
    # 逐个遍历，往 numRows 个桶里来回扔
    # 实现“来回扔”—— 0 时 step = 1 , 最大值时 step = -1,然后每次 + step
    def convert_good(self, s, numRows):
        if numRows == 1 or numRows >= len(s):
            return s

        L = [''] * numRows  # ['', '', '', '']
        
        index, step = 0, 1

        for x in s:
            L[index] += x
            if index == 0:
                step = 1
            elif index == numRows -1:
                step = -1               # -1  绝了！
            index += step
        print(L)
        return ''.join(L)

solution = Solution()
s = "ABCDEF"
ret = solution.convert_good(s, 4)
print(ret)