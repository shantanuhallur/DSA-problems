class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))return "0";
        int l1 = num1.length();
        int l2 = num2.length();
        int[] res = new int[l1+l2];
        
        int i = l2 - 1;
        int pf = 0;
        while(i >= 0){
            int ival = num2.charAt(i)-'0';
            i--;
            
            int j = l1 - 1;
            int k = res.length -1 - pf;
            int c = 0;
            
            while(j>=0 || c != 0){
                int jval = j>=0?num1.charAt(j)-'0':0;
                j--;
                
                int prod = (ival * jval) + c + res[k];
                res[k] = prod%10;
                c = prod/10;
                k--;
            }
            pf++;
        }
        
        //management of leading zeros
        String str="";
        boolean flag = false;
        
        for(int val:res){
            if(val==0 && flag == false){
                //leading zero
                continue;
            }
            else{
                flag=true;
                str += val;
            }
        }
        return str;
    }
}