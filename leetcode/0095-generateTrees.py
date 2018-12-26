# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        if n <= 0:
            return []
        return self.generateBst(1, n)
    
    def generateBst(self, left, right):
        nodes = []
        if left > right:
            nodes.append(None)
        for i in range(left, right+1):
            leftNodes = self.generateBst(left, i-1)
            rightNodes = self.generateBst(i+1, right)
            for leftNode in leftNodes:
                for rightNode in rightNodes:
                    root = TreeNode(i)
                    root.left, root.right = leftNode, rightNode
                    nodes.append(root)
        return nodes
