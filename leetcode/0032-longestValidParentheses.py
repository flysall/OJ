class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if s == None or len(s) == 0:
            return 0
        stack = []
        left, length = -1, 0
        for i in range(len(s)):
            if s[i] == "(":
                stack.append(i)
            else:
                if len(stack) == 0:
                    left = i
                else:
                    stack.pop()
                    if len(stack) == 0:
                        cur_len = i - left
                        length = max(cur_len, length)
                    else:
                        cur_len = i - stack[-1]
                        length = max(cur_len, length)
        return length
