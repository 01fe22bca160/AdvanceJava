import java.sql.*;
class MyFirstJDBCProgram {
    public static void main(String[] args)  {
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
            // Step  3: Create Statement
        Statement stmt = con.createStatement();

        // Step 4 : Execute Statement
        String sql = "Create table Student(sid int primary key , sname varchar(20), city varchar(20))";
        //int r =stmt.executeUpdate(sql);
        //  String insertSql= "Insert into student values(3 , 'Arjun' , 'Mumabi')";
        // int r =stmt.executeUpdate(insertSql);
        // boolean success = stmt.execute(insertSql);
        // ResultSet rs = stmt.executeQuery(insertSql);
        String selectSql = "select * from student";
         boolean success = stmt.execute(selectSql);
         int r =stmt.executeUpdate(selectSql);
         ResultSet rs = stmt.executeQuery(selectSql);
        // System.out.println(r);
        // System.out.println(success);
        //  System.out.println(rs);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3)+ " ");
            System.out.println(rs.getInt("sid") + " " + rs.getString("sname") + " " + rs.getString("city")+ " ");
        }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
       
     
    }
}

