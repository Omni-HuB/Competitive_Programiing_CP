
import java.util.*;
public class A{

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        int t2=sc.nextInt();

        while(t2>0){


            int n=sc.nextInt();

            int ones=0;
            int negOne=0;

            for(int i3=0;i3<n;i3++){

                int val=sc.nextInt();
                if(val==1){
                ones++;}
                else{
                negOne++;}
            }

            if(ones==n){
                System.out.println("0");
            }else if(negOne<ones){

              if(negOne%2==0){
                System.out.println("0");
              }else{
                System.out.println("1");
              }
            }else if(negOne==ones){
                if(negOne%2==0){
                    System.out.println("0");
                  }else{
                    System.out.println("1");
                  }
            }else{
                int half=n/2;
                int df=negOne-half;
                if(half%2!=0)
                df++;

                System.out.println(df);
            }
            t2--;
        }
        sc.close();
    }
}