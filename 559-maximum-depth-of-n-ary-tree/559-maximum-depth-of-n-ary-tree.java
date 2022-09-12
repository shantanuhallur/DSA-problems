/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max = 1;
    public int maxDepth(Node root) {
        if(root==null)return 0;
            maxDepthN(root,1);
        
        return max;
    }
    public void maxDepthN(Node node,int h){
        
        if(node.children.size()==0){
            max = h>max?h:max;
            return; //as it can be set again in to lower depth levels again eg:- 2 , 4                                                                                  Nodes.
        }
        

        for(Node child : node.children){
             maxDepthN(child,h+1);
        }
        return;
    }
}