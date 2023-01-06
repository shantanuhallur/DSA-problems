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
    public TreeNode correctBinaryTree(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        set.add(root.val);
        
        while(que.size()!=0) {
            int size = que.size();
            while(size-->0) {
                TreeNode removeN = que.removeFirst();
                
                if(removeN.right!=null) {
                    if(removeN.right.right!=null && set.contains(removeN.right.right.val)){
                            removeN.right = null;
                        }
                        else{
                            set.add(removeN.right.val);
                            que.addLast(removeN.right);
                        }
                }
                    
                if(removeN.left!=null) {
                        if(removeN.left.right!=null && set.contains(removeN.left.right.val)) {
                                removeN.left = null;
                            }
                            else{
                                set.add(removeN.left.val);
                                que.addLast(removeN.left); 
                            }
                        }
                    }
                }
        return root;
    }
}