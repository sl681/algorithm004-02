 class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                count++;//括号加错，最后count数字过大
                }
            
        
        return count;
    }
   private void dfs(char [][]grid,int i,int j){
       if(i<0||j<0||j>=grid[0].length||i>=grid.length||grid[i][j]=='0')return ;
       grid[i][j]='0';
       dfs(grid,i+1,j);
       dfs(grid,i-1,j);
       dfs(grid,i,j-1);
       dfs(grid,i,j+1);
       /* dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);*/


   }
}
