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
    public void inorder(TreeNode node, ArrayList<Integer> sortedList) {
        //Bcase Case
        if(node == null) return;
        
        //left and right recursive call
        inorder(node.left,sortedList);
        // INORDER AREA ------>>>
        
        sortedList.add(node.val);
        
        // INORDER AREA ------>>>
        inorder(node.right,sortedList);
    }
    
    public TreeNode buildBST(ArrayList<Integer> sortedList, int st,int end) {
        //Base Case
        if(st > end) return null;
        //calculate mid
        int mid = (st+end)/2;
        TreeNode root = new TreeNode(sortedList.get(mid));
        //attach left and right recursively created subtrees to left and right of our root;
        root.left = buildBST(sortedList,st,mid-1);
        root.right = buildBST(sortedList,mid+1,end);
        
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
         ArrayList<Integer> sortedList = new ArrayList<>();
        inorder(root,sortedList);
        
        return buildBST(sortedList,0,sortedList.size()-1);
    }
}