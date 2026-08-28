// LeetCode 994: Rotting Oranges
// Link: https://leetcode.com/problems/rotting-oranges/
// Approach: Multi-source BFS. Start by pushing all initially rotten oranges
// into the queue with time=0, and count total fresh oranges. BFS level by
// level, rotting adjacent fresh oranges and tracking elapsed time. If the
// count of oranges rotted during BFS doesn't match the total fresh count,
// some oranges were unreachable -> return -1. Otherwise return max time.
// Time: O(n*m), Space: O(n*m) for visited array + queue

class Pair
{
    int row;
    int col;
    int tym;
    Pair(int _row,int _col,int _tym)
    {
        row = _row;
        col = _col;
        tym = _tym;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int cntfrsh=0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    vis[i][j]=2;
                    q.add(new Pair(i,j,0));
                }
                else if(grid[i][j]==1)
                {
                    cntfrsh++;
                }
            }
        }
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        int time =0;
        int cnt =0;
        while(!q.isEmpty())
        {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tym;
            time = Math.max(t,time);
            q.remove();
            for(int i=0;i<4;i++)
            {
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0)
                {
                    vis[nrow][ncol] = 2;
                    q.add(new Pair(nrow,ncol,t+1));
                    cnt++;
                }
            }
        }
        if(cnt!=cntfrsh)
        {
            return -1;
        }
        return time;
    }
}