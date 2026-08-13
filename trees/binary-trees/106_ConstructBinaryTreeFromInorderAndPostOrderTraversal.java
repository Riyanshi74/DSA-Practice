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
 /*Since you're processing postorder and the root is always the last unread element, you need to:

Start reading from the end of the array, not somewhere in the middle.
Move backwards (decrement), not forwards.
Because you're reading root values from the end, you build right subtree before left subtree — mirror image of the preorder approach.(LC 105)*/
class Solution {
    private int postorderidx ;
    private HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        postorderidx = postorder.length - 1;
        for(int i=0;i<len;i++)
        {
            map.put(inorder[i],i);
        }
        return build(postorder,0,len-1);
    }
    public TreeNode build(int[] postorder,int inorderstrt,int inorderend)
    {
        if(inorderstrt>inorderend)
        {
            return null;
        }
        int rootval = postorder[postorderidx];
        postorderidx--;
        int inorderidx = map.get(rootval);
        TreeNode root = new TreeNode(rootval);
        root.right = build(postorder,inorderidx+1,inorderend);
        root.left = build(postorder,inorderstrt,inorderidx-1);
        return root;
    }
}