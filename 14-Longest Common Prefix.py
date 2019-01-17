class Solution:
    def longestComonPrefix(self, strs):
        # 垃圾代码
        # if not strs:
        #     return ''
        # if len(strs) == 1:
        #     return strs[0]
        # i = j = 0
        # while True:
        #     for j in range(len(strs) - 1):
        #         if i >= len(strs[j]) or i >=len(strs[j + 1]) or strs[j][i] != strs[j + 1][i]:
        #             if i == 0:
        #                 return ""
        #             else:
        #                 return strs[j][:i]
        #     i += 1
        if not strs: return ''
				#since list of string will be sorted and retrieved min max by alphebetic order
        s1 = min(strs)
        s2 = max(strs)
        print(s1)
        print(s2)
        for i, c in enumerate(s1):
            if c != s2[i]:
                return s1[:i] #stop until hit the split index
        return s1



solution = Solution()
ret = solution.longestComonPrefix(["bac","bac","bacc"])
print(ret)