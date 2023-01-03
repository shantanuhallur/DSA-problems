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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashMap<Integer,Integer> freq = new HashMap<>();
        //add frequencies and create all nodes.
        for(int[] node : descriptions) {
             if(!map.containsKey(node[0])){ 
                TreeNode createdNode = new TreeNode(node[0]);
                 map.put(node[0],createdNode);
             }
            if(!map.containsKey(node[1])){ 
                TreeNode createdNode = new TreeNode(node[1]);
                 map.put(node[1],createdNode);
             }
                 freq.put(node[1],freq.getOrDefault(node[1],0)+1);
        }
        //attach nodes
        for(int[] node : descriptions) {
            TreeNode from = map.get(node[0]);
            TreeNode to = map.get(node[1]);
            //attach left
            if(node[2]==1) from.left = to;
        //attach right
            else from.right = to;
        }
         // Return root;  
         for(int[] node : descriptions) {
             if(!freq.containsKey(node[0])) return map.get(node[0]);
         }   
        return null;
    }
}