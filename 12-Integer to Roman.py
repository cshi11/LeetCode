class Solution:
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        r_num = []
        i = 0
        ROMAN = {0: ['I', 'V', 'X'], 1: ['X', 'L', 'C'], 2: ['C', 'D', 'M'], 3: ['M', '', '']}

        def invert(n, r1, r5, r10):
            if n is 4:
                return r1 + r5
            elif n is 9:
                return r1 + r10
            else:
                return r5 * (n // 5) + r1 * (n % 5)
            

        while(num > 0):
            n = num % 10
            rom = invert(n, ROMAN.get(i)[0], ROMAN.get(i)[1], ROMAN.get(i)[2])
            r_num.insert(0, rom)
            num = num // 10
            i += 1
        return ''.join(r_num)
        


solution = Solution()
ret = solution.intToRoman(1994)
print(ret)
        