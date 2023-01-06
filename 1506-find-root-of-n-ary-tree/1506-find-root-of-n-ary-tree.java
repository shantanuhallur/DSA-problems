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
    
    public Node(int _val,ArrayList<Node> _child0ren) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        HashSet<Integer> childrenSet = new HashSet<>();
        //add every nodes all the children in our set.
        for(Node node : tree) {
            for(Node child : node.children) {
                childrenSet.add(child.val);
            }
        }
        Node root = null;
        //check which node is not present in children set, that node is our root node.
        for(Node node : tree) {
            if(!childrenSet.contains(node.val)) root = node;
        }
        
        return root;
    }
}