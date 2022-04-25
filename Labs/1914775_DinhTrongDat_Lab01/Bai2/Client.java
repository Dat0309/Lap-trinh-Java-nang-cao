import java.awt.*;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.*;
import java.io.*;

public class Client extends JFrame implements ActionListener{
    JTextField sendThis;
    JButton send;

    public Client( ) {
        super("Simple Client");
        Container con = getContentPane( );
        con.setLayout(new FlowLayout( ) );
        sendThis = new JTextField(15);
        con.add(sendThis);
        send = new JButton("Send");
        send.addActionListener(this);
        con.add(send);
        setSize(400,400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent action) {
        Socket client = null;
        DataOutputStream output;
        try {
            // client = new Socket( InetAddress.getByName("kneedeep.cis.famu.edu"),8000);
            client = new Socket(InetAddress.getLocalHost(),8000);
            output = new DataOutputStream(client.getOutputStream());
            output.writeUTF(sendThis.getText());
        } 
        catch(IOException e) { e.printStackTrace(); }
    }

    public static void main(String args[] ) {
        Client c = new Client();
        c.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }
}