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
    
    void serialize(TreeNode* node,string& s) {
        if(!node) {
            s +="#,";
            return;
        }
        
        s+= to_string(node->val)+",";
        serialize(node->left,s);
        serialize(node->right,s);
    }
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        string sb ="";
        serialize(root,sb);
        return sb ;
    }
    
    vector<string> arr;
    void convert(string& data){
        stringstream ss(data);
        string word;
        while(!ss.eof()){
            getline(ss,word,',');
            arr.push_back(word);
        }
    }
    int st = 0;
    TreeNode* deserialize(int end) {
        if(st>end) return NULL;
        if(arr[st] =="#") {
            st++;
            return NULL;
        }
        TreeNode* root = new TreeNode(stoi(arr[st++]));
        root->left = deserialize(end);
        root->right = deserialize(end);
        return root;
    }
    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        convert(data);
        TreeNode* root = deserialize(arr.size()-1);
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec* ser = new Codec();
// Codec* deser = new Codec();
// string tree = ser->serialize(root);
// TreeNode* ans = deser->deserialize(tree);
// return ans;