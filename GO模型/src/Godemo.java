import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
public class Godemo {
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
       int N=t.size();
        double tn=t.get(N-1);
        double xl=0;
        double xr=0;
        double xm=0;
        double epslv=0.001;
        double a=0;
        double b=0;
        double D=Dfunction(t);
        double f=0;
//步骤1:判断D大小
        if(D>0&&D<0.5)
        {
            xl=(1-2*D)/2;
            xr=1/D;

        }
        else {

            input.close();//终止计算
            return ;}
//转步骤2：

        while (true)
        {      xm=(xl+xr)/2;
            if(Math.abs(xr-xl)<=epslv)
                break;
            else{
                double y=Math.exp(xm);
                //步骤3
                f=(1-D*xm)*y+(D-1)*xm-1;
                if(f>epslv)
                {
                    xl=xm;
                    continue;
                }
                else if(f<-epslv)
                {
                    xr=xm;
                    continue;
                }

            }

        }
//步骤4
        b=xm/tn;
        double ahelp=Math.exp(-b*tn);
        a=N/(1-ahelp);
        System.out.println("当epslv="+epslv+"时，");
        System.out.println("a="+a);
        System.out.println("b="+b);

input.close();
    }
    public static double Dfunction(ArrayList<Double> list)
    {
        double result=0;
        int n=list.size();
        for(int i=1;i<n;i++)
        {double t1=list.get(i);
          result+=t1;

        }
        double tn=list.get(n-1);
        result=result/tn;
        result=result/n;
        return result;


    }
}
