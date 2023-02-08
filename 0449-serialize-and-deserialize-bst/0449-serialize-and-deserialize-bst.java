/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:
    
    void serialize(TreeNode* node,string & sb) {
        //Base Case
        if(!node) {
            sb+= "#,";
            return;
        }
        
        sb+= to_string(node->val) +",";
        //dfs
        serialize(node->left,sb);
        serialize(node->right,sb);
    }
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        string sb;
        serialize(root,sb);
        return sb;
    }
    int st =0;
    TreeNode* desrialize(vector<string>& arr,int end) {
        //Base Case
        if(st>end) return NULL;
        if(arr[st]=="#"){
            st++;
            return NULL;
        }
        //build root
        TreeNode* root = new TreeNode(stoi(arr[st++]));
        //recursively build tree
        root->left = desrialize(arr,end);
        root->right = desrialize(arr,end);
        return root;
    }
    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        vector<string> arr;
        stringstream ss(data);
        string word;
        while(!ss.eof()) {
            getline(ss,word,',');
            arr.push_back(word);
        }
        //returns a build tree
        TreeNode* root = desrialize(arr,arr.size()-1);
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec* ser = new Codec();
// Codec* deser = new Codec();
// string tree = ser->serialize(root);
// TreeNode* ans = deser->deserialize(tree);
// return ans;