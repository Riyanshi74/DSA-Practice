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
 
 * LC 105: Construct Binary Tree from Preorder and Inorder Traversal
 *
 * APPROACH:
 * - Preorder = [root, left subtree..., right subtree...] -> first element is ALWAYS the root
 * - Inorder  = [left subtree..., root, right subtree...] -> root's position splits array into left/right
 *
 * STEPS:
 * 1. Build a HashMap: value -> index in inorder array (for O(1) lookup instead of linear search)
 *    map.put(inorder[i], i)
 * 2. Use a global/class-level preorderIndex pointer (starts at 0), NEVER resets across recursive calls
 *    - every recursive call reads preorder[preorderIndex], then increments it
 *    - this works because preorder is always read strictly left to right: root, then ALL of left subtree, then ALL of right subtree
 * 3. Recursive build(inorderStart, inorderEnd):
 *    - base case: if inorderStart > inorderEnd -> return null (no nodes left)
 *    - rootVal = preorder[preorderIndex++]  -> next unread value is always the current subtree's root
 *    - rootIdx = map.get(rootVal)           -> find split point in inorder
 *    - root.left  = build(inorderStart, rootIdx - 1)   -> MUST build left before right
 *    - root.right = build(rootIdx + 1, inorderEnd)
 *    - return root
 *
 * WHY LEFT BEFORE RIGHT MATTERS:
 * preorderIndex is shared/global -> whichever call runs first consumes the next chunk of preorder.
 * Since preorder lists entire left subtree before any right subtree values, left MUST be built first,
 * otherwise right subtree would wrongly consume left subtree's preorder values.
 *
 * MAP DIRECTION: must be value -> index (NOT index -> value)
 * because we always look up "given this root VALUE, where does it split inorder" -> get(value) = index
 * (works only because problem guarantees unique values; duplicates would make this ambiguous)
 *
 * Time: O(n)  - each node processed once, O(1) map lookup
 * Space: O(n) - map + recursion stack
 */
class Solution {
    private int preorderidx = 0;
    private Map<Integer,Integer> inorderidxmap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        for(int i=0;i<len;i++)
        {
            inorderidxmap.put(inorder[i],i);
        }
        return build(preorder,0,len-1);
    }
    private TreeNode build(int[] preorder,int inorderstrt,int inorderend)
    {
        if(inorderstrt>inorderend)
        {
            return null;
        }
        int rootval = preorder[preorderidx];
        preorderidx++;
        TreeNode root = new TreeNode(rootval);
        int inorderidx = inorderidxmap.get(rootval);
        root.left = build(preorder,inorderstrt,inorderidx-1);
        root.right = build(preorder,inorderidx+1,inorderend);
        return root;
    }
}