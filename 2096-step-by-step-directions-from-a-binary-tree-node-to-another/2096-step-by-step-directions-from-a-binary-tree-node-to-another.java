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
   StringBuilder temp;
    public void getPath(TreeNode node,int target,StringBuilder psf) {
        if(node == null) return;
        if(node.val == target){
            temp = new StringBuilder(psf);
            return;
        }
            getPath(node.left,target,psf.append("L"));
            psf.delete(psf.length()-1,psf.length());
            getPath(node.right,target,psf.append("R"));
            psf.delete(psf.length()-1,psf.length());
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pass = new StringBuilder(); 
        getPath(root,startValue,pass);
        StringBuilder s= new StringBuilder(temp);
        temp = new StringBuilder();
        getPath(root,destValue,pass);
        StringBuilder d = new StringBuilder(temp);
        int i=0;int j=0;        
        System.out.print("s: " + s + " d: " +d);
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