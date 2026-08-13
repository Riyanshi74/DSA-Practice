// LeetCode 236: Lowest Common Ancestor of a Binary Tree
// Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*Approach: For any node, recursively check the left and right subtrees:
If p and q are found in different subtrees (one on left, one on right) → the current node is the LCA, because it's the deepest point where their paths split.
If both are found in the same subtree → the LCA must be deeper down that side, so keep returning from there.
If the current node itself is p or q → return it immediately (it could be the LCA of itself and a descendant).*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p==root || q==root)
        {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        // p and q found in different subtrees -> current root is the LCA
        if(left!=null && right!=null)
        {
            return root;
        }
        //otherwise, if left is not null then the LCA is in left and if ryt is not null then its in the right subtree
        return left!=null? left:right;
    }
}