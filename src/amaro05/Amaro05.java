
package amaro05;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.animation.Animation.Status;


public class Amaro05 {
    
    
public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:angel.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }

    
    public static void main(String[] args) {
       Scanner sc = new Scanner (System .in); 
       System. out. printf("Enter  ID: ");
       int id = sc. nextInt();
       System.out.print("Student First Name: ");
        String fname = sc.next();
        System.out.println("Student Last Name:");
        String lname = sc.next();
        System.out.print("Student email:");
        String email = sc.next();
        System.out.print("Status: ");
        String status = sc.next();
        
        String sql = "INSERT INTO Student (s_id, s_fname, s_lname, s_email, s_status)"
               + "VALUES (?, ?, ?,?,?)";
        
      try{
            Connection con = connectDB();
            PreparedStatement pst = con.prepareStatement (sql);
            pst.setInt(1,id);
            pst.setString(2, fname);
            pst.setString(3, lname);
            pst.setString(4, email);
            pst.setString(5, status);
            pst.executeUpdate();
            
            System.out.println("Inserted Sucessfully!");
     
         
        } catch (SQLException e){
            
            System.out.println("Connection Error!: "+e.getMessage());
            
        }
                

    }

   
}
