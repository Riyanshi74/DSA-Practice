// LeetCode 662: Maximum Width of Binary Tree
// Link: https://leetcode.com/problems/maximum-width-of-binary-tree/
// Approach: BFS level order traversal, assigning each node a position index
// (like a complete binary tree: left child = 2*i, right child = 2*i + 1).
// Width of a level = last index - first index + 1 at that level.
// Time: O(n), Space: O(n) for the queue

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int first = 0, last = 0;

            for (int i = 0; i < levelSize; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                int index = current.index;

                if (i == 0) first = index;
                if (i == levelSize - 1) last = index;

                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * index));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * index + 1));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }

    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}