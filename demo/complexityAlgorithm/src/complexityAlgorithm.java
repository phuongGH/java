public class complexityAlgorithm {
    public int exp1(int a, int b){
        int ans = 1;            //1
        
        while (b>0) {           //1
            ans *= a;           //1 * b
            b -= 1;             //1
        }
        return ans;             //1
        //time 2 + 3b
    }
    
    
    public  int exp2(int a, int b){
        if(b==1){                       //1
            return a;               
        }else{
            return a*exp2(a, b-1);       //2
        }
        
        //3b -1
        
        /*
            t(b) = 3 + t(b-1)
                 = 3 + 3 + t(b-2)
                 = 3 + 3 + 3 + t(b-3)
                 = 3*k + t(b-k) dung lai khi b-k =1 -> k=b-1
                 = 3(b-1) + t(1)    //t(1)<=> b==1 gom 1 so sanh va 1 return
                 = 3(b-1) + 2
                 = 3b -1;
        */
    }
    
    public int exp3(int a, int b){
        if(b==1){                       //1
            return a;                   //1
        }if((b%2)*2==b){                //3
            return exp3(a*a, b/2);      //2
        }else{
            return a*exp3(a, b-1);      //2
        }
        //12log2(b)+1
        /*
            b chan  t(b) = 6 + t(b/2)
            b le    t(b) = 6 + t(b-1)
                         = 6 + 6 + t((b-1)/2)
                         = 6 + 6 + t(b/2)      ((b-1)/2 nho hon b/2)
                         = 6 + 6 + 12 + t(b/4)
                         = 6 + 6 + 12 + 12 + t(b/8)
                         = 12k + t(b/(2^k))         b=2^k => k = log2(b)
                         = 12log2(b)+1
        */

    }
    
}
