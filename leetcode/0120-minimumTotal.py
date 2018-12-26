class Solution:
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        res = [0 for _ in range(len(triangle)+1)]
        for i in range(len(triangle)-1, -1, -1):
            row = triangle[i]
            for j in range(len(row)):
                res[j] = min(res[j], res[j+1]) + row[j]
        return res[0]
        
