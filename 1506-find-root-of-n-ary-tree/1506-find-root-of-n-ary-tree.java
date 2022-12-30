/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        HashMap<Integer,Integer> map = new HashMap();
        
        for(Node node:tree) {
            for(Node child:node.children) {
                map.put(child.val,map.getOrDefault(child.val,0)+1);
            }
        }
        Node root = null;
        for(Node node:tree) {
            if(!map.containsKey(node.val)) root = node;
        }
        
        return root;
    }
}