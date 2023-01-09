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
    public void inorder(TreeNode node,List<Integer> list) {
        if(node==null) return;
        
        //left and right recursive calls
        inorder(node.left,list);
        //INORDER AREA ---->>>
        list.add(node.val);
        //INORDER AREA ---->>>
        inorder(node.right,list);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        inorder(root1,list1);
        inorder(root2,list2);
        System.out.print(list1 + " " + list2);
        //merge these 2 sorted lists
        List<Integer> ans = new ArrayList<>();
        int i=0; int j=0;
        while(i<list1.size() && j<list2.size()) {
            if(list1.get(i) < list2.get(j)) {
                ans.add(list1.get(i++));
            }
            else{ //element in lest 2 is smaller
                ans.add(list2.get(j++));
            }
        }
        
        while(i<list1.size()) ans.add(list1.get(i++));
        while(j<list2.size()) ans.add(list2.get(j++));
        //return our ans arraylist which is now merged.
        return ans;
    }
}