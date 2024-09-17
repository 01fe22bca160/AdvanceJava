import java.sql.*;
import java.util.Scanner;
public class  ScrollableResultset
{
public static void main(String[] args) {
    String DB_URL= "jdbc:oracle:thin:@localhost:1521:xe";
        String USER = "SYSTEM";
        String PASSWORD = "BCA5C";

        // Step 1 :Regsiter the driver class
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Step 2: Open DB conncetion 
            Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            if (con!=null){
                System.out.println("Connected to Oracle DB");
            }else{
                System.out.println("Failed to make conncetion to Oracle");
            }
     //  Statement stmt=con.createStatement();
    
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("select * from Student");
        System.out.println(rs);
         System.out.println("Move Forward");
         while(rs.next()){
          System.out.println("Printing Student data in forward direction");
          System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
         }
         System.out.println("Move Backward");
         rs.last();
         while(rs.previous()){
          System.out.println("Printing student data in backward direction");
          System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));

         }
         con.close();
    } catch(ClassNotFoundException e){
           e.printStackTrace();
    }
    catch(SQLException s){
            s.printStackTrace();
    }
}
}