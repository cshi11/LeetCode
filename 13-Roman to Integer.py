class Solution:
    def intToRoman(self, s):
        """
        :type s: int
        :rtype: str
        """
        ROMAN = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        num_list = list (s)
        sum = 0
        for i in range(len(num_list) - 1):
            if (num_list[i] is 'I') and ((num_list[i + 1] is 'V') or (num_list[i + 1] is 'X')):
                sum += -1
            elif (num_list[i] is 'X') and ((num_list[i + 1] is 'L') or (num_list[i + 1] is 'C')):
                sum += -10
            elif (num_list[i] is 'C') and ((num_list[i + 1] is 'D') or (num_list[i + 1] is 'M')):
                sum += -100
            else:
                sum += ROMAN.get(num_list[i])
        length = len(num_list)
        sum += ROMAN.get(num_list[length - 1])
        return sum 



solution = Solution()
ret = solution.intToRoman('MCMXCIV')
print(ret)
