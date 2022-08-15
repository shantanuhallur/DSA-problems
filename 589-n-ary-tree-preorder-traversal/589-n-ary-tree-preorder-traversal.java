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
    public List<Integer> preorder(Node root) {
        LinkedList<Node> st = new LinkedList<>();
        LinkedList<Integer> output_arr =  new LinkedList<>();
        if(root==null){
            return output_arr;
        }
        st.add(root);
        
        while(!st.isEmpty()){
            Node node = st.pollLast();
            
            for(int child = node.children.size()-1;child>=0;child--){
                st.addLast(node.children.get(child));
            }
            output_arr.add(node.val);
        }
        return output_arr;
    }
}