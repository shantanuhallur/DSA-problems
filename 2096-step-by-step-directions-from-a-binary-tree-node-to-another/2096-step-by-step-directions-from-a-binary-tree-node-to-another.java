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
    StringBuilder s = new StringBuilder();
	StringBuilder d = new StringBuilder();
    public boolean dfs (TreeNode node, int target,boolean start) {
        if(node == null) return false;
        if(node.val == target) return true;
        
        boolean l = dfs(node.left,target,start);
        if(l) {
            if(start)s.append("L");
            else d.append("L");
            return true;
        }
        
        boolean r = dfs(node.right,target,start);
        if(r){
            if(start)s.append("R");
            else d.append("R");
            return true;
        }
        return false;
    }
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root,startValue,true);
        dfs(root,destValue,false);
        s.reverse();
        d.reverse();
        int i=0;int j=0;
        while(i<s.length() && j<d.length()) {
                if(s.charAt(i)  == d.charAt(j)) {
                    i++; j++;
                }
                else break;
        }
        StringBuilder ans = new StringBuilder();
        while(i<s.length()) {
            ans.append("U");
            i++;
        } 
        ans.append(d.substring(j));
        return ans.toString();
    }
}