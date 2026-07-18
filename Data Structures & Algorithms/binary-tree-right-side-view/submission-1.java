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

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        if(root==null)
        return ans;
        
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=1;i<=size;i++){
                TreeNode tmp=q.poll();
                if(i==1)
                ans.add(tmp.val);
                if(tmp.right!=null)
                q.offer(tmp.right);
                if(tmp.left!=null)
                q.offer(tmp.left);
            }
        }
        return ans;
    }
}
