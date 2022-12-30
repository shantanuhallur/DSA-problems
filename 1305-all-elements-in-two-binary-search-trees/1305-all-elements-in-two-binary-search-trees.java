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
    
    public void getArray(TreeNode node,List<Integer> list) {
        if(node == null) return;
        
        getArray(node.left,list);
        list.add(node.val);
        getArray(node.right,list);
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
       List<Integer> l1 = new ArrayList<>();
       List<Integer> l2 = new ArrayList<>();
        getArray(root1,l1);
        getArray(root2,l2);
        int i=0;
        int j=0;
        List<Integer> ans = new ArrayList<>();
        while(i!= l1.size() && j!= l2.size()) {
            if(l1.get(i)<l2.get(j)){
                ans.add(l1.get(i++));
            }
            else{
                ans.add(l2.get(j++));
            }
        }
        while(i!=l1.size()) ans.add(l1.get(i++));
        while(j!=l2.size()) ans.add(l2.get(j++));
    
        return ans;
    }
}