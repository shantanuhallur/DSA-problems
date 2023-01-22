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
        if(node==NULL){
            sb+= "#,";
            return;
        }
        sb+= to_string(node->val) + ",";
        serialize(node->left,sb);
        serialize(node->right,sb);
    }
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        string sb="";
        serialize(root,sb);
        return sb;
    }
    int s = 0;
    TreeNode* buildTree(vector<string>& arr,int end){
        if(s>end) return NULL;
        if(arr[s]=="#") {
            s++;
            return NULL;
        }
        
        TreeNode* root = new TreeNode(stoi(arr[s++])); 
        root->left =  buildTree(arr,end);
        root->right = buildTree(arr,end);
        return root;
    }
    vector<string> arr1;
    void adv_tokenizer(string s, char del)
{
    stringstream ss(s);
    string word;
    while (!ss.eof()) {
        getline(ss, word, del);
        // cout << word << endl;
        arr1.push_back(word);
    }
}
    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        
        adv_tokenizer(data,',');
        TreeNode* root = buildTree(arr1,data.size()-1);
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec* ser = new Codec();
// Codec* deser = new Codec();
// string tree = ser->serialize(root);
// TreeNode* ans = deser->deserialize(tree);
// return ans;