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
    public void fillList(TreeNode node,ArrayList<Integer> list) {
        //Base case
        if(node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        
        //Left Recursive Call
        if(node.left!=null) {
            fillList(node.left,list);
        }
        
        //Right Recursive Call
        if(node.right !=null) {
            fillList(node.right,list);
        }
        
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        //filled both lists
        fillList(root1,list1);
        fillList(root2,list2);
        //checked if both lists are of same size
        int list1Size = list1.size();
        int list2Size = list2.size();
        //if not all the leaves are not same
        if(list1Size != list2Size) return false;
        //checked if all leaves are same
        while(--list1Size >=0) {
            //if no we return false
            if(list1.get(list1Size) != list2.get(list1Size)) return false;
        }
        //if yes we return true
        return true;
    }
}