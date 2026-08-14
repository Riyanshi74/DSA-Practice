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
 /*
 * LC 114: Flatten Binary Tree to Linked List
 * Goal: rearrange tree in-place so it becomes a chain using only .right pointers,
 *       in PREORDER order (root, left, right). All .left must end up null.
 *
 * APPROACH (in-place, O(1) space, iterative):
 * - Walk through the tree using curr, starting at root.
 * - At each curr:
 *     - if curr.left == null -> nothing to do, just move curr = curr.right
 *     - if curr.left != null:
 *         1. Find the RIGHTMOST node of curr's left subtree (call it temp)
 *            -> this is the last node preorder would visit in that left subtree
 *         2. Splice: temp.right = curr.right
 *            -> attach curr's original right subtree AFTER the left subtree ends
 *         3. Move left subtree into right's position: curr.right = curr.left
 *         4. Clear: curr.left = null
 * - Move curr = curr.right and repeat (this naturally walks INTO the spliced-in
 *   left subtree next, continuing the flattening process node by node)
 *
 * WHY IT WORKS:
 * Preorder = root -> entire left subtree -> entire right subtree.
 * So after flattening the left subtree, the very next node in preorder should be
 * whatever the original right subtree's first node was. Finding the left subtree's
 * rightmost node tells us exactly where to "attach" the original right subtree.
 *
 * WHY curr = curr.right AT THE END STILL WORKS:
 * curr.right now points into the just-spliced left subtree, so we keep advancing
 * through it node by node, re-checking for a .left at each one, until eventually
 * we reach nodes that never had a left child to begin with -> loop terminates.
 *
 * Time: O(n) amortized (each node's "find rightmost" walk collectively touches
 *       each node ~once across the whole run, similar to Morris traversal logic)
 * Space: O(1) - no recursion, no extra data structure, pure pointer rewiring
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root==null)
        {
            return;
        }
        TreeNode curr = root;
        while(curr!=null)
        {
            if(curr.left!=null)
            {
                TreeNode temp = curr.left;
                while(temp.right!=null)
                {
                    temp=temp.right;
                }
                temp.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }
        return;
    }
}