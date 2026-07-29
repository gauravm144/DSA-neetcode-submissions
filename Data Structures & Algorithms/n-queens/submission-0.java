class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] visited=new boolean[n][n];
        List<List<String>> ans=new ArrayList<>();
        find(0,ans,visited);
        return ans;
    }
    void find(int row,List<List<String>> ans,boolean[][] visited){
        if(row==visited.length){
            List<String> inside=new ArrayList<>();
            for(int i=0;i<visited.length;i++){
                StringBuilder tmp=new StringBuilder();
                for(int j=0;j<visited.length;j++){
                    if(visited[i][j]==true)
                    tmp.append("Q");
                    else
                    tmp.append(".");
                }
            inside.add(tmp.toString());
            }
            ans.add(inside);
            return;
        }
        for(int i=0;i<visited.length;i++){
            if(visited[row][i]==false&&check(visited,row,i))
            {
                visited[row][i]=true;
                find(row+1,ans,visited);
                visited[row][i]=false;
            }
        }
    }
    boolean check(boolean[][] visited,int row,int col){
        for(int i=0;i<row;i++)
        if(visited[i][col]==true)
        return false;

        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--)
        if(visited[i][j]==true)
        return false;

        for(int i=row-1,j=col+1;i>=0&&j<visited.length;i--,j++)
        if(visited[i][j]==true)
        return false;

        return true;
    }
}
