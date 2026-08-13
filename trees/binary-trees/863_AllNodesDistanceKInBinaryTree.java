// LeetCode 863: All Nodes Distance K in Binary Tree
// Link: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
// Approach: Build a parent map via DFS so the tree can be treated as an
// undirected graph. Then BFS from target, moving to left/right/parent
// neighbors, until exactly k levels have been expanded. The queue at that
// point holds all nodes at distance k.
// Time: O(n), Space: O(n) for the parent map, visited set, and queue

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        buildparentmap(root,null,map);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int distance = 0;
        while(!q.isEmpty())
        {
            if(distance==k)
            {
                break;
            }
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node = q.peek();
                q.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                TreeNode parent = map.get(node);
                if(left!=null && !visited.contains(left))
                {
                    visited.add(left);
                    q.offer(left);
                }
                if(right!=null && !visited.contains(right))
                {
                    visited.add(right);
                    q.offer(right);
                }
                if(parent!=null && !visited.contains(parent))
                {
                    visited.add(parent);
                    q.offer(parent);
                }
            }
            distance++;
        }
        // When the loop breaks:
        // The while loop breaks the moment distance == k, before processing that level.
        // So the queue at that point holds exactly the nodes that were enqueued during
        // the previous iteration — i.e., all nodes at distance k from target.
        List<Integer> res = new ArrayList<>();
        int s = q.size();
        for(int i=0;i<s;i++)
        {
            TreeNode n = q.peek();
            q.poll();
            res.add(n.val);
        }
        return res;
    }

    public void buildparentmap(TreeNode node, TreeNode parent, HashMap<TreeNode,TreeNode> map)
    {
        if(node==null)
        {
            return;
        }
        map.put(node,parent);
        buildparentmap(node.left,node,map);
        buildparentmap(node.right,node,map);
    }
}