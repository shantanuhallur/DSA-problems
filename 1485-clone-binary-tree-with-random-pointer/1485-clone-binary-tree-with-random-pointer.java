/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    HashMap<Node,NodeCopy> map;
    public NodeCopy copy(Node node) {
        if(node==null) return null;
        
        NodeCopy root = map.getOrDefault(node, new NodeCopy(node.val));
        map.put(node,root);
        
        if(node.random!=null) {
            root.random = map.getOrDefault(node.random,new NodeCopy(node.random.val));   
            map.put(node.random,root.random);
        }
        
        root.left = copy(node.left);
        root.right = copy(node.right);
        
        return root;
    }
    
    public NodeCopy copyRandomBinaryTree(Node root) {
        map = new HashMap<>();
        return copy(root);
    }
}