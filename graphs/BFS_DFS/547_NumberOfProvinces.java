// LeetCode 547: Number of Provinces
// Link: https://leetcode.com/problems/number-of-provinces/
// Approach: DFS on the adjacency matrix. Treat each city as a graph node —
// isConnected[i][j] == 1 means an edge exists between city i and city j.
// For every unvisited city, start a new DFS (this means we found a new
// province) and mark every city reachable from it as visited. The number
// of times we start a fresh DFS = number of provinces.
// Time: O(n^2), Space: O(n) for visited array + recursion stack

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                count++;              // found a new province
                dfs(i, vis, isConnected);   // mark everyone in this province as visited
            }
        }
        return count;
    }

    public static void dfs(int node, boolean vis[], int[][] isConnected) {
        vis[node] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[node][j] == 1 && vis[j] == false) {
                dfs(j, vis, isConnected);
            }
        }
    }
}