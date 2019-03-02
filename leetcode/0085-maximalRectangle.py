class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if not matrix or len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        area = 0
        line = [0 for i in range(len(matrix[0]))]
        is_processed = [False for i in range(len(matrix[0]))]
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if matrix[i][j] == "1":
                    line[j] += 1
                    is_processed[j] = False
                else:
                    line[j] = 0
                    is_processed[j] = True
            length = len(matrix[i])
            for j in range(length):
                if is_processed[j]:
                    continue
                left_move, right_move = 1, 1
                while j+right_move < length and line[j] <= line[j+right_move]:
                    if line[j] == line[j+right_move]:
                        is_processed[j+right_move] = True
                    right_move += 1
                while j-left_move >= 0 and line[j] <= line[j-left_move]:
                    left_move += 1
                cur_area = line[j] * (right_move + left_move - 1)
                area = max(cur_area, area)
        return area
