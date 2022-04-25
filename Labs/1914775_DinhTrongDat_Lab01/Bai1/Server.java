import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Server extends JFrame {
    JTextArea display;

    public Server( ) {
        super("Simple Server"); 

        Container con = getContentPane();

        display = new JTextArea(10,30);
        display.setEditable(false);

        con.add(display);

        setSize(400,300);
        setVisible(true);
    }

    public void startServer() {
        ServerSocket server = null;
        Socket connection = null;
        DataInputStream input;
        long gt;
        try {
            server = new ServerSocket(8000);
            while (true) {
                connection = server.accept();
                display.append("Connection established\n");
                input = new DataInputStream(connection.getInputStream());
                gt = giaiThua(input.readInt());
                display.append("Giai thua: " + gt + "\n");
                connection.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long giaiThua(int n){
        long gt = 1;
        if(n==0 || n == 1)
            return gt;
        else{
            for(int i=2;i<=n;i++)
                gt*=i;
            return gt;
        }
    }

    public static void main(String args[]) {
        Server s = new Server();
        s.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        s.startServer();
    }
}