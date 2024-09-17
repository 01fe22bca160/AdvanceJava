import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedStmt {
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
            //Step 3 : Create Preapred Statement
            String insertSql= "Insert into student values(? , ? , ?)";
            PreparedStatement pstmt = con.prepareStatement(insertSql);
            Scanner scan=new Scanner(System.in);
            System.out.println("Enter Student details or type Q to quit");
            while (!"Q".equals(scan.next())) {
            // Step 4 : Execute statement
            System.out.print("Enter student sid");
            int sid=scan.nextInt();
            System.out.print("Enter student name");
            String sname=scan.next();
            System.out.print("Enter student city");
            String scity=scan.next();
            pstmt.setInt(1, sid);
            pstmt.setString(2, sname);
            pstmt.setString(3, scity);
            int r =pstmt.executeUpdate();
            System.out.println(r);
            System.out.print("Student entered successfully.Do you want to continue(y/N/ or type Q to quit?)");
            }
            // step 5: close connection
            con.close();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
       
     
    }
}