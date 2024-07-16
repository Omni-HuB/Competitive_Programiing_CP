import java.util.*;
public class Long_Long{

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        int input=sc.nextInt();

        while(input>0){        

            int n=sc.nextInt();
            long sum2=0;
            long opn=0;
            int gt=0;

            for(int i=0;i<n;i++){

                int val=sc.nextInt();
                
                if(val<=0){

                    if(val<0)
                    gt=1;
                }else{
                    if(gt==1)
                    opn++;

                    gt=0;
                }
                if(val<0)
                val=val*-1;

                sum2=sum2+(long)val;
            }
         
            if(gt==1)
            opn++;
            
            System.out.println(sum2+" "+opn);
            input--;
        }


    }
    
} 
