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
    public void getleafS(TreeNode node, ArrayList<Integer> ans) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            ans.add(node.val);
            return;
        }
        
            getleafS(node.left,ans);            

            getleafS(node.right,ans);            
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> ans1 = new ArrayList<>(); 
        ArrayList<Integer> ans2 = new ArrayList<>();
        getleafS(root1,ans1);
        getleafS(root2,ans2);
        int i = ans1.size();
        int j = ans2.size();
        
        if(i != j) return false;
        
        while(--i>=0){
            if(ans1.get(i) != ans2.get(i)) return false;
        }
        
        return true;
    }
}