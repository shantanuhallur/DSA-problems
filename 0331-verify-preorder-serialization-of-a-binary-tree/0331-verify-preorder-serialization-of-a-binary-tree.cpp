class Solution {
public:
    bool isValidSerialization(string preorder) {
        stringstream ss(preorder);
        string word;
        int diff = 1;
        while(getline(ss,word,',')) {
            if(--diff<0) return false;
            if(word!="#") diff+=2;
        }
        return diff==0;
    }
};