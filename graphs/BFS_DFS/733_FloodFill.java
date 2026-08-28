// LeetCode 733: Flood Fill
// Link: https://leetcode.com/problems/flood-fill/
// Approach: Standard BFS flood fill. Start from (sr, sc), remember the
// original color (initialc), and BFS outward — coloring each visited cell
// with the new color and only expanding to neighbors that still match the
// original color and haven't been visited yet.
// Time: O(n*m), Space: O(n*m) for visited array + queue

class Pair
{
    int row;
    int col;
    int ic;
    int color;
    Pair(int _row,int _col,int _ic,int _color)
    {
        row = _row;
        col = _col;
        ic = _ic;
        color = _color; 
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r = image.length;
        int c = image[0].length;
        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[r][c];
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        vis[sr][sc] = 1;
        int initialc = image[sr][sc];
        q.add(new Pair(sr,sc,initialc,color));
        while(!q.isEmpty())
        {
            int row = q.peek().row;
            int col = q.peek().col;
            int ic = q.peek().ic;
            int nc = q.peek().color;
            image[row][col] = nc;
            q.poll();
            for(int i=0;i<4;i++)
            {
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 && nrow<r && ncol>=0 && ncol<c && image[nrow][ncol]==ic && vis[nrow][ncol]==0)
                {
                    q.add(new Pair(nrow,ncol,image[nrow][ncol],nc));
                    vis[nrow][ncol]=1;
                }
            }
        }
        return image;
    }
}