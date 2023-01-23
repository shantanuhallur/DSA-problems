/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    void serialize(TreeNode node, StringBuilder sb) {
        //Bsae Case
        if(node==null) {
            sb.append("#,");
            return;
        }
        
        sb.append(node.val+",");
        //preorder traversal
        serialize(node.left,sb);
        serialize(node.right,sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //create a stringbuilder sb and traverse and create preorder string;
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        System.out.print(sb);
        return sb.toString();
    }
    int st = 0;
    public TreeNode deserialize(String[] arr ,int end) {
        //Base Case
        if(st>end) return null;
        if(arr[st].equals("#")) {
            st++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[st++]));
        //recursively build tree in left and right
        root.left = deserialize(arr,end);
        root.right = deserialize(arr,end);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //create String array
        String[] arr = data.split(",");
        TreeNode root = deserialize(arr,arr.length-1);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;