import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Server_21s21047 implements Runnable{
    @Override
    public void run()
    {
        try{
            String URL="jdbc:derby://localhost:1527/Muzna21";
            String USER="Muzn21";
            String PASS="Mzn96793715";
            
            Connection N_21S21047 =DriverManager.getConnection(URL,USER,PASS);
            ServerSocket SS_21S21047=new ServerSocket(8000);
            System.out.println("server is running....");
           
            while(true){
            Socket W_21S21047=SS_21S21047.accept();
            
            DataInputStream X_21S21047 = new DataInputStream(W_21S21047.getInputStream());
            int B_21s21047= X_21S21047.readInt();
            int t_21s21047 =X_21S21047 .readInt();
            System.out.println("Your BILLNUMBER"+B_21s21047);
             System.out.println("TARIFFRATE"+t_21s21047);
             
             Statement Y_21S21047=N_21S21047.createStatement();
             String J_21S21047="SELECT*FROM MUZN21.BILLNUMBER FETCH FIRST 100 ROWS ONLY="+B_21s21047;
            ResultSet G_21S21047=Y_21S21047.executeQuery(J_21S21047);
            
            DataOutputStream Q_21S21047 = new DataOutputStream(W_21S21047.getOutputStream());
            while(G_21S21047.next()){
                String O=G_21S21047.getString("COUTOMERTYPE");
                double PR=G_21S21047.getDouble("PRICE");
                double p=PR* t_21s21047;
                Q_21S21047.writeUTF(O);
                Q_21S21047.writeDouble(PR);
                System.out.println("Send to client");
                Q_21S21047.flush();
  
            }
       
        }
    }   catch (IOException | SQLException ex) {
            
        }
    
}
}
