package javabasic;

public class BreakContinue {
    public static void show(){
        int n = 10;
        for(int i=0; i<n;i++)
        {
             for(int j=0; j<n;j++)
             {
                 //bỏ qua vòng lặp
//                 if(j==5)
//                 {
//                     break;
//                 }
                 
                 //bỏ qua 1 bước trong vòng lặp
                  if(j==6)
                 {
                     continue;
                 }
                 
                 System.out.println("i " + i + " j " + j);
             }
        }
    }
}
