/**
 * Definition for a Node.
 * struct Node {
 *     int val;
 *     Node *left;
 *     Node *right;
 *     Node *random;
 *     Node() : val(0), left(nullptr), right(nullptr), random(nullptr) {}
 *     Node(int x) : val(x), left(nullptr), right(nullptr), random(nullptr) {}
 *     Node(int x, Node *left, Node *right, Node *random) : val(x), left(left), right(right), random(random) {}
 * };
 */

class Solution {
public:
    unordered_map<Node*,NodeCopy*> map;
    NodeCopy* copy(Node* node) {
        if(!node) return nullptr;
        
        NodeCopy* root = nullptr;
        if(map.find(node) == map.end()) {
            root = new NodeCopy(node->val);
            map[node] = root;
        }
        else {
            root = map.at(node);
        }
        
        if(node->random){
            if(map.find(node->random) == map.end()){
                root->random = new NodeCopy(node->random->val);
                map[node->random] = root->random;
            }
            else{
                root->random = map.at(node->random);   
            }
        }
        
        root->left = copy(node->left);
        root->right = copy(node->right);
        
        return root;
    }
    
    NodeCopy* copyRandomBinaryTree(Node* root) {
        
        return copy(root);
        
    }
};