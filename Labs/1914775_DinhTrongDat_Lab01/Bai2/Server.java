import java.net.*;
import java.util.ArrayList;
import java.util.List;
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
        String msg;
        String[] mangSoNguyen = {};
        try {
            server = new ServerSocket(8000);
            while (true) {
                connection = server.accept();
                display.append("Connection established\n");
                input = new DataInputStream(connection.getInputStream());
                msg = input.readUTF();
                mangSoNguyen = msg.split(",");
                arange(mangSoNguyen);
                display.append("Mảng sau khi sắp xếp là :\n");
                for (int i = 0; i < mangSoNguyen.length; i++) {
                    display.append(mangSoNguyen[i] + " ");
                }
                
                connection.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void arange(String[] arr){
        int temp = Integer.valueOf(arr[0]);
        for(int i = 0;i< arr.length - 1; i++){
            for(int j = i+1; j< arr.length; j++){
                if(Integer.valueOf(arr[i]) > Integer.valueOf(arr[j])){
                    temp = Integer.valueOf(arr[j]);
                    arr[j] = arr[i];
                    arr[i] = String.valueOf(temp);
                }
            }
        }
    }

    public static void main(String args[]) {
        Server s = new Server();
        s.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        s.startServer();
    }
}