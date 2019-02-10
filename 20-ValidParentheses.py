class Solution:
    def isValid(self, s):
        d = {')': '(', ']': '[', '}': '{'}
        stack = list()
        for each in s:
            if each in d.values():
                stack.append(each)
            elif each in d.keys():
                if stack == [] or d[each] != stack.pop():
                    return False
            else:
                return False

        return stack == []

solution = Solution()
s = "()"
print(solution.isValid(s))
