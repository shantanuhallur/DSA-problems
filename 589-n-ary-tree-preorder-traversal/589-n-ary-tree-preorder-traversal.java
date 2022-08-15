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
        Stack<Node> st = new Stack<>();
        LinkedList<Integer> output_arr =  new LinkedList<>();
        if(root==null){
            return output_arr;
        }
        st.add(root);
        
        while(!st.isEmpty()){
            Node node = st.pop();
            
            for(int child = node.children.size()-1;child>=0;child--){
                st.push(node.children.get(child));
            }
            output_arr.add(node.val);
        }
        return output_arr;
    }
}