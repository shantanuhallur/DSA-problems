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

    void serialize(TreeNode* node,string& sb) {
        if(!node) {
            sb+="#,";
            return;
        }
        sb+= to_string(node->val) +",";
        serialize(node->left,sb);
        serialize(node->right,sb);
    }
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        string sb = "";
        serialize(root,sb);
        return sb;
    }
    
    int st=0;
    TreeNode* deserialize(vector<string>& arr,int end) {
        if(st>end) return NULL;
        if(arr[st]=="#"){
            st++;
            return NULL;
        }
        TreeNode* root = new TreeNode(stoi(arr[st++]));
        root->left =  deserialize(arr,end);
        root->right = deserialize(arr,end);
        return root;
    }
    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        stringstream ss(data);
        string word;
        vector<string> arr;
        while(!ss.eof()) {
            getline(ss,word,',');
            arr.push_back(word);
        }
        
        TreeNode* root = deserialize(arr,arr.size()-1);
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec* ser = new Codec();
// Codec* deser = new Codec();
// string tree = ser->serialize(root);
// TreeNode* ans = deser->deserialize(tree);
// return ans;