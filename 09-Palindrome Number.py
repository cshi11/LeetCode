import operator as op

class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        number = str(x)
        pal_number = number[::-1]
        if op.eq(number, pal_number):
            return True
        else:
            return False

solution = Solution()
ret = solution.isPalindrome(-121)
print(ret)