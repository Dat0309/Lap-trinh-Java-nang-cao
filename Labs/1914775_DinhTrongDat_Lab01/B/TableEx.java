import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.event.*;

public class TableEx extends JPanel {
    static JFrame myFrame;
    String data[][] = { { "1", "Introduction" },
            { "2", "What Java can Do for You" },
            { "3", "JAVA Design" },
            { "4", "Installing JAVA" },
            { "5", "JDK tools" },
            { "6", "Object-Oriented Programming" }, { "7", "Hello world" },
            { "8", "Data Types" },
            { "9", "Methods" },
            { "10", "Using Expressions" } };
    String columnNames[] = { "Chapter Number", "Chapter Title" };

    public TableEx(){
        setLayout(new BorderLayout());
        JTable table = new JTable(data,columnNames);
        JScrollPane pane = JTable.createScrollPaneForTable(table);
        add(pane);
    }

    public static void main(String args[]) {
        myFrame = new JFrame("Table Example");
        TableEx tableExample = new TableEx();
        myFrame.getContentPane().add("Center", tableExample);
        myFrame.setSize(400, 250);
        myFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        myFrame.setVisible(true);
    }
}