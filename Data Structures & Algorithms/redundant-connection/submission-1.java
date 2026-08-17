class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] parent =new int[n+1];
        
        for(int i=0;i<n;i++)
        parent[i]=i;

        for(int i=0;i<n;i++){
            int a=find(edges[i][0],parent);
            int b=find(edges[i][1],parent);
            if(a==b){
                return edges[i];
            }
            parent[b]=a;
        }
        return new int[2];
    }
    int find(int x,int[]parent){
        if(parent[x]==x)
        return x;
        return parent[x]=find(parent[x],parent);
    }
}
