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
    public int getHeight(TreeNode node) {
        if(node==null) return -1;
        
        int leftH = getHeight(node.left);
        int rightH = getHeight(node.right);
        
        return Math.max(leftH,rightH) +1;
    }
    
    public void fillAns(List<List<String>> ans,int left,int right,int level,TreeNode node) {
        if(node == null) return;
        int mid = (left+right)/2;
        ans.get(level).set(mid,String.valueOf(node.val));
        
        fillAns(ans,left,mid-1,level+1,node.left);
        fillAns(ans,mid+1,right,level+1,node.right);
    }
    
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        int height = getHeight(root);
        int row = height+1; //ROW
        int col = (int) Math.pow(2,height+1) -1; //COL
        //creating a grid
        for(int i=0;i<row;i++) {
            List<String> list = new ArrayList<>();
            for(int j=0;j<col;j++) {
                list.add("");
            }
            ans.add(list);
        }
        
        int left =0;
        int right = col-1;
        int level = 0;
        
        fillAns(ans,left,right,level,root);
        
        return ans;
    }
}