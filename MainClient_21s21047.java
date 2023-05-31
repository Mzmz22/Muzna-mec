import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class Client_21s21047 implements Runnable 
{
    @Override
    public void run()
    {
        try
        { 
            Socket rk_21s21047 = new Socket ("locahost",8000);
            Scanner th_21s21047=new Scanner(System.in);
            
            System.out.println("Enter BILLNUMBER");
            int fg_21s21047=th_21s21047.nextInt();
            System.out.println("Enter Number of Cups");
            int UI_21S21047=th_21s21047.nextInt();
            //send
            DataOutputStream pp_21s21047=new DataOutputStream (rk_21s21047.getOutputStream());
            pp_21s21047.writeInt(fg_21s21047);
            pp_21s21047.writeInt(UI_21S21047);
            pp_21s21047.flush();
            
            //recive
            DataInputStream qq_21s21047 = new DataInputStream(rk_21s21047.getInputStream());
            String B_21s21047 =qq_21s21047.readUTF();
            double t_21s21047 =qq_21s21047.readDouble();
            double s_21S21047=qq_21s21047.readDouble();
            System.out.println("The BILLNUMBER"+B_21s21047);
            System.out.println("The TARIFFRATE"+t_21s21047);
            System.out.println("The Sales"+s_21S21047);
        }
        catch(IOException e) {
            
        } 
    }    
             
}
