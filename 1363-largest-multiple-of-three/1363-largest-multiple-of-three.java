class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int n = digits.length;
        int sum = 0;
        for(int i=0;i<n;i++)sum+=digits[i];
        
        Arrays.sort(digits);
        if(sum%3==0){
            if(digits[n-1]==0){
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            for(int i=n-1;i>=0;i--){
                sb.append(digits[i]);
            }
            return sb.toString();
        }
        else if(sum%3==1){
            //searching for smallest element which gives X%3==1 in a sorted array.
         boolean idealFound = false;
            for(int i=0;i<n;i++){
                if(digits[i]%3==1){
                    idealFound = true;
                    digits[i]=-1;
                    break;
                }
            }
            if(!idealFound){
                int[] idexs = new int[2];
                idexs[0] = -1;
                idexs[1] = -1;
                
                for(int i=0;i<n;i++){
                    if(digits[i]%3==2){
                        if(idexs[0]==-1)idexs[0]=i;
                        else {
                          idexs[1]= i;
                            break;
                        } 
                    }
                }
                if(idexs[1]!=-1){
                    digits[idexs[0]] = -1;
                    digits[idexs[1]] = -1;
                }
                else{
                    return "";
                }
            }
        }
        else{
             boolean idealFound = false;
            for(int i=0;i<n;i++){
                if(digits[i]%3==2){
                    idealFound = true;
                    digits[i]=-1;
                    break;
                }
            }
            if(!idealFound){
                int[] idexs = new int[2];
                idexs[0] = -1;
                idexs[1] = -1;
                
                for(int i=0;i<n;i++){
                    if(digits[i]%3==1){
                        if(idexs[0]==-1)idexs[0]=i;
                        else {
                          idexs[1]= i;
                            break;
                        } 
                    }
                }
                if(idexs[1]!=-1){
                    digits[idexs[0]] = -1;
                    digits[idexs[1]] = -1;
                }
                else{
                    return "";
                }
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            if(digits[i]!=-1){
                ans.append(digits[i]);
            }
        }
        if(ans.length()>0 && ans.toString().charAt(0)=='0'){
            return "0";
        }
        return ans.toString();
    }
}