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
    public int height(Node node) {
        if(node==null) return 0;
        
        int nodeH = 0;
        for(Node child:node.children) {
            nodeH = Math.max(nodeH,height(child));
        }
        
        return nodeH + 1;
    }
    public int maxH =0;
    public void findMaxDia(Node node) {
        int firstH = 0;
        int secondH = 0;
        for(Node child:node.children) {
            int childH = height(child);
            if(childH>=firstH){
                secondH = firstH;
                firstH = childH;
            }
            else if(childH>=secondH) {
                secondH = childH;
            }
            maxH = Math.max(maxH,firstH+secondH);
        }
        
        for(Node child : node.children) {
            findMaxDia(child);
        }
    }
    public int diameter(Node root) {
        findMaxDia(root);
        return maxH;
    }
}