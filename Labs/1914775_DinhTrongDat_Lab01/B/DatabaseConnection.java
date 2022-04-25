import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DatabaseConnection {
    Connection conn = null;
    String url = "jdbc:mysql://localhost:444/";
    String dbName = "lab0";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "";
    Statement stmt;
    ResultSet rs;
    ResultSetMetaData rsmd;

    public DatabaseConnection() throws ClassNotFoundException,
        InstantiationException, IllegalAccessException {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            stmt = (Statement) conn.createStatement();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void TheLoaiSach(String strSQL){
        try{
            rs = ((java.sql.Statement) stmt).executeQuery(strSQL);
            rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
            while(rs.next()){
                for(int i=1; i<col; i++){
                    System.out.println(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
    }

    public void Insert_TheLoaiSach(String strSQL){
        try{
            ((java.sql.Statement) stmt).executeUpdate(strSQL);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
    }
     
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        DatabaseConnection Obj = new DatabaseConnection();
        String Matl = "CNTT", TenTL = "CONG NGHE THONG TIN";
        String strSQL = "Insert into TheLoai Values('"+Matl+"','"+TenTL+"');";
        strSQL = "Select + From TheLoai ;";
        Obj.TheLoaiSach(strSQL);
    }
}