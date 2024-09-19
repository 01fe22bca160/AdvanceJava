import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class JDBCRowSetExample {
    
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        JdbcRowSet rowSet=RowSetProvider.newFactory().createJdbcRowSet();
        rowSet.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        rowSet.setUsername("SYSTEM");
        rowSet.setPassword("BCA5C");
        rowSet.setCommand("Select * from Student where sid=?");
        rowSet.setInt(1, 135);
      //  rowSet.setCommand("Select * from Student ");
        rowSet.execute();
       while(rowSet.next()){
            System.out.println("Id: "+rowSet.getInt(1));
            System.out.println("Name:"+rowSet.getString(2));
            System.out.println("City:"+rowSet.getString(3));

        }
       /* while(rowSet.previous()){
            System.out.println("Id: "+rowSet.getInt(1));
            System.out.println("Name:"+rowSet.getString(2));
            System.out.println("City:"+rowSet.getString(3));
            
        }
        rowSet.absolute(2);
        System.out.println("Id: "+rowSet.getInt(1));
            System.out.println("Name:"+rowSet.getString(2));
            System.out.println("City:"+rowSet.getString(3));*/

    }
}