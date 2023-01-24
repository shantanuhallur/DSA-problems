class Solution {
public:
    bool isValidSerialization(string preorder) {
        stringstream ss(preorder);
        string data;
        int diff=1;
       while(!ss.eof()) {
           getline(ss,data,',');
           if(--diff<0) return false;
           if(data!="#") diff+=2;
       }
        return diff==0;
    }
};