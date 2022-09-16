/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        
        while(node!=null){
            //cause it is sure that p || q will be in its subtree anyway and this is LCA.
            if(node== p || node == q){
                return node;
            }
                boolean pIsOnLeft = p.val<node.val;
                boolean qIsOnLeft = q.val<node.val;

                //means that they are on different subtrees means curr node is LCA. 
                if(pIsOnLeft != qIsOnLeft){
                    return node;
                }
                else{ //else means both q and p are on left or right subtree of this node. 
                    node = pIsOnLeft?node.left:node.right;
                }
            }
            return null;
        }
    }
