// LeetCode 144: Binary Tree Preorder Traversal
// Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
// Approach: Recursive DFS — visit root, then left subtree, then right subtree
// Time: O(n), Space: O(n) for recursion stack (O(h) in balanced tree)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);       // visit root
        preorder(node.left, result); // then left
        preorder(node.right, result); // then right
    }
}