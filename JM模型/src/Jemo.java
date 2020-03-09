
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.ArrayList;

public class Jemo {
   // private static double list;

    public static void main(String[] args) throws Exception{

   //用double类型的ArrayList来存储ti
        ArrayList<Double> t=new ArrayList<Double>();

     File inputFile =new File("SYS1(failue_count).txt");
        Scanner input=new Scanner(inputFile);
        //BufferReader
     while(input.hasNext())
     {
         int failure_Number=input.nextInt();
         double Timetofailure=input.nextDouble();
         int  lable=input.nextInt();
         t.add(Timetofailure);
         //System.out.println(Timetofailure);
     }

        int n=t.size();
        double left=0;
        double right=0;
        double ex=0.0001;
        double ey=0.0001;
        double root=0;
        double N0=0;
        double Fi=0;
        double P=getP(t);
        System.out.println("when ex="+ex+",ey="+ey+"时");
        //步骤1，并转步骤2
       if(P>((n-1)/2))
         {
         left=n-1;
         right=n;
          }
    else{
   input.close();//终止计算
    return ;
}
    //步骤2，判断f(right)
while(function(t,right)>ey){//重复步骤2
    left=right;
    right=right+1;
}
if(function(t,right)>=(ex))
{root=right;//之后转步骤5
}
else{//步骤3
    while(true){
        if(Math.abs(right-left)<ex)
        {root=(right+left)/2;
        break;
        }
        root=(right+left)/2;
        //步骤4
       if(function(t,root)>ey){
           left=root;
       }
       else{
           if(function(t,root)<(-ey)){
               right=root;
           }
           else break;
       }
    }
}
//步骤5
        N0=root;
    double sum=0;
    double tn=t.get(n-1);
for(int i=1;i<n;i++)
{
    double t1=t.get(i);
    double t2=t.get(i-1);
    sum=sum+(i-1)*(t1-t2);
}
Fi=(n-1)/(N0*tn-sum);
System.out.println("N0="+N0);
System.out.println("Fi="+Fi);
input.close();
    }

//求P，用double类型的list存储数据t
    public  static double getP(ArrayList<Double> list)
    {
        double result=0;
        int n=list.size();
        for(int i=1;i<n;i++)
        {double t1=list.get(i);
        double t2=list.get(i-1);
        result=result+(i-1)*(t1-t2);
        }
        double tn=list.get(n-1);
        result=result/tn;
        return result;
    }
//函数function(N)
    public static  double function(ArrayList<Double> list,double N)
    {
        double result =0;
        int n=list.size();
        double P=getP(list);
        for(int i=1;i<n;i++)
        {
            result=result+(1/(N-i+1));
        }
        result=result-((n-1)/(N-P));
        return result;
    }
}
