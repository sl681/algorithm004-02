# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        white, gray = 0, 1
        res = []
        stack = [(white, root)]
        
        while stack:
            color, node = stack.pop()
            
            if node is None:
                continue
            
            if color == white:
                stack.append((white, node.right))
                stack.append((white, node.left))
                stack.append((gray, node))
            else :
                res.append(node.val)
            
        return res	